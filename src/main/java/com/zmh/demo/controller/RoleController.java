package com.zmh.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.zmh.demo.enty.Role;
import com.zmh.demo.mapper.RoleMapper;
import com.zmh.demo.service.RoleService;
import com.zmh.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleMapper roleMapper;

    @GetMapping("/get")
    public Result getRoles(@RequestParam Integer pageSize,
                           @RequestParam Integer pageNum){
        PageHelper.startPage(pageNum,pageSize);
        HashMap map1=new HashMap();
        QueryWrapper wrapper=new QueryWrapper();
        List<Role> list=roleMapper.selectList(wrapper);
        map1.put("data",list);
        map1.put("total",roleMapper.total());
        return Result.success(map1);
    }

    @PostMapping("/save")
    @Transactional
    public Result InsertRole(@RequestBody Role role){
          roleMapper.insert(role);
          return Result.success("插入数据成功");
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public Result delete(@PathVariable Integer id){
        roleMapper.deleteById(id);
        return Result.success();
    }

    @PostMapping("/delete")
    @Transactional
    public Result deletes(@RequestBody List<Integer> list){
        roleMapper.deleteBatchIds(list);
        return Result.success();
    }

    @GetMapping("/toget")
    public Result toget(){
        List<String> list = roleMapper.togetRole();
        return Result.success(list);
    }
}
