package com.zmh.demo.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.github.pagehelper.PageHelper;
import com.zmh.demo.enty.User;
import com.zmh.demo.mapper.UserMapper;
import com.zmh.demo.service.UserService;
import com.zmh.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserServiceController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping("/selectone/{username}")
    public User selectOne(@PathVariable String username){
        HashMap map=new HashMap();
        map.put("username",username);
        try{
            return userMapper.SelectQueryUser(map).get(0);
        }catch (Exception e){
            return new User();
        }
    }


    @GetMapping("/select")
    public Result UserTo(@RequestParam(value = "pageNum") Integer pageNum,
                         @RequestParam(value = "pageSize") Integer pageSize,
                         @RequestParam(value = "username") String username){
        //PageHelper 只对其后的第一个查询有效
        PageHelper.startPage(pageNum,pageSize);
        HashMap map=new HashMap();
        map.put("username",username);
        HashMap map1=new HashMap();
        List<User> users = userMapper.SelectQueryUser(map);
        map1.put("data",users);
        map1.put("total",userMapper.todoSize(username));
        return Result.success(map1);
    }

    @PostMapping("/save")
    public Result Save(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public Result delete(@PathVariable Integer id){
        userMapper.deleteById(id);
        return Result.success("删除成功");
    }

    @PostMapping("/deletes")
    @Transactional
    public Result deletes(@RequestBody List<Integer> ids){
        try{
            userMapper.deleteBatchIds(ids);
            return Result.success("操作成功!");
        }catch (Exception e){
            return Result.error();
        }
    }


    @GetMapping("/export")
    public Result exports(HttpServletResponse response){
        try{
            HashMap map=new HashMap();
            List<User> list = userMapper.SelectQueryUser(map);

            ExcelWriter writer= ExcelUtil.getWriter(true);

            /*指定别名*/
            writer.addHeaderAlias("username","用户名");
            writer.addHeaderAlias("id","id号码");
            writer.addHeaderAlias("password","密码");
            writer.addHeaderAlias("createTime","创建日期");
            writer.addHeaderAlias("token","认证");

            writer.write(list,true);

            /*设置浏览器响应的格式*/
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
            String filename= URLEncoder.encode("用户信息","UTF-8");
            response.setHeader("Content-Disposition","attachment;filename="+filename+".xlsx");

            ServletOutputStream outputStream=response.getOutputStream();
            writer.flush(outputStream,true);
            outputStream.close();
            writer.close();
            return Result.success("导出成功!");
        }catch (Exception e){
            return Result.error();
        }
    }

    @PostMapping("/import")
    public void importst(MultipartFile file) throws IOException {
            InputStream stream=file.getInputStream();
            ExcelReader reader=ExcelUtil.getReader(stream);
            /*忽略表中第一行中文*/
            List<List<Object>> lists=reader.read(1);
            List<User> list= CollUtil.newArrayList();
            for(List<Object> row : lists){
                User user=new User();
                user.setUsername((String) row.get(0));
                if(row.get(1) != null){
                    user.setId(Integer.valueOf(row.get(1).toString()));
                }
                user.setPassword(row.get(2).toString());
                try{
                    user.setCreateTime(DateUtil.parseDate(row.get(3).toString()));
                }catch (Exception e){
                    user.setCreateTime(null);
                }
                user.setToken(null);
                list.add(user);
            }
            userService.saveBath(list);
    }

    @RequestMapping("/getTimes")
    public Result toset(@RequestParam Integer pageNum,
                        @RequestParam Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        HashMap map=new HashMap();
        map.put("data",userMapper.set());
        map.put("total",userMapper.set().size());
        return Result.success(map);
    }
}
