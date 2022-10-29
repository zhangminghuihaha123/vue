package com.zmh.demo.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.zmh.demo.enty.Files;
import com.zmh.demo.enty.User;
import com.zmh.demo.mapper.FileMapper;
import com.zmh.demo.mapper.UserMapper;
import com.zmh.demo.service.FileService;
import com.zmh.demo.util.CardToCheck;
import com.zmh.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @Autowired
    private FileMapper fileMapper;

    @Autowired
    private UserMapper userMapper;

    @Value("${files.upload.path}")
    private String Filepath;

    @PostMapping("/upload")
    public Result upload(@RequestParam MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String type = FileUtil.extName(originalFilename);
        long size = file.getSize();
        //存储到磁盘
        File files = new File(Filepath);
        if(!files.exists()){
            /*不存在创建该文件*/
            files.mkdir();
        }
        File upfile = new File(Filepath + originalFilename);
        Files files1=new Files();
        files1.setFilename(originalFilename);
        files1.setType(type);
        files1.setSize(size);
        files1.setAvater("http://localhost:8080/file/img/"+originalFilename);
        if(!upfile.exists()){
            file.transferTo(upfile);
            fileMapper.insert(files1);
        }
        return Result.success();
    }

    @PostMapping("/getimg")
    public Result getimgs(@RequestBody User user){
        String hope=CardToCheck.todo(user.getAvater());
        String avater="http://localhost:8080/file/img/"+hope;
        user.setAvater(avater);
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("username",user.getUsername());
        userMapper.update(user,wrapper);
        return Result.success("操作成功!");
    }

    /*通过链接下载文件*/
    @RequestMapping("/img/{imgURL}")
    public void download(@PathVariable String imgURL, HttpServletResponse response) throws IOException {
        File upfile = new File(Filepath + imgURL);
        ServletOutputStream stream=response.getOutputStream();
        response.addHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(imgURL,"UTF-8"));
        response.setContentType("application/octet-stream");
        stream.write(FileUtil.readBytes(upfile));
        stream.flush();
        stream.close();
    }

    @GetMapping("/get")
    public Result getFiles(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam String filename){
        PageHelper.startPage(pageNum,pageSize);
        HashMap map=new HashMap();
        map.put("filename",filename);
        HashMap map1=new HashMap();
        map1.put("data",fileMapper.QueryListFile(map));
        map1.put("total",fileMapper.QueryFileNUm(filename));
        return Result.success(map1);
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteFile(@PathVariable Integer id){
        return fileService.delete(id);
    }

    @PostMapping("/delete")
    public Result deletesFile(@RequestBody List<Integer> ids){
        return fileService.deletes(ids);
    }

    @PostMapping("/bol")
    public void bol(@RequestBody Files file){
        if(file.getCheck()){
            //1
            fileMapper.updateCheck(1,file.getId());
        }else {
            //0
            fileMapper.updateCheck(0,file.getId());
        }
    }


    @PostMapping("/editorImg")
    public JSONObject editorImg(@RequestParam MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String type = FileUtil.extName(originalFilename);
        long size = file.getSize();
        //存储到磁盘
        File files = new File(Filepath);
        if(!files.exists()){
            /*不存在创建该文件*/
            files.mkdir();
        }
        File upfile = new File(Filepath + originalFilename);
        Files files1=new Files();
        files1.setFilename(originalFilename);
        files1.setType(type);
        files1.setSize(size);
        String url="http://localhost:8080/file/img/"+originalFilename;
        files1.setAvater(url);
        if(!upfile.exists()){
            file.transferTo(upfile);
            fileMapper.insert(files1);
        }

        return JSONUtil.parseObj("{\"errno\": 0, \"data\": [{\"url\": \"" + url + "\"}]}");
    }

}
