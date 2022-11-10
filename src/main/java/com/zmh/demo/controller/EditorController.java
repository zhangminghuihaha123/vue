package com.zmh.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.zmh.demo.enty.Editor;
import com.zmh.demo.interceptor.MyInterFace.AcrossToken;
import com.zmh.demo.mapper.EditMapper;
import com.zmh.demo.service.EditService;
import com.zmh.demo.util.CardToCheck;
import com.zmh.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/edit")
public class EditorController {

    @Autowired
    private EditMapper editMapper;

    @Autowired
    private EditService editService;

    @PostMapping("/save")
    public Result save(@RequestBody Editor editor){
        String avater = CardToCheck.todo(editor.getAvater());
        String title=editor.getTitle();
        String test=editor.getTest();
        Editor editor1=new Editor();
        if(!StrUtil.isBlank(avater)){
            editor1.setAvater("http://localhost:8080/file/img/"+avater);
        }
        editor1.setTest(test);
        editor1.setTitle(title);
        editService.save(editor1);
        return Result.success();
    }


    @GetMapping("/get")
    public Result getEditor(@RequestParam String titleName,
                            @RequestParam Integer pageNum,
                            @RequestParam Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.like("title","%"+titleName+"%");
        HashMap map=new HashMap();
        map.put("data",editMapper.selectList(wrapper));
        map.put("total",editMapper.total(titleName));
        return Result.success(map);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        editMapper.deleteById(id);
        return Result.success();
    }

    @PostMapping("/deletes")
    public  Result deletes(@RequestBody List<Integer> ids){
        editMapper.deleteBatchIds(ids);
        return Result.success();
    }

    @GetMapping("/getAll")
    @AcrossToken
    public Result getAll(){
        QueryWrapper wrapper=new QueryWrapper();
        return Result.success(editMapper.selectList(wrapper));
    }

    @GetMapping("/getOne")
    @AcrossToken
    public Result getOne(@RequestParam Integer id){
        return Result.success(editMapper.selectById(id));
    }
}
