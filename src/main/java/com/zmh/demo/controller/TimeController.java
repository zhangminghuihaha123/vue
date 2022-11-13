package com.zmh.demo.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zmh.demo.enty.Time;
import com.zmh.demo.mapper.TimeMapper;
import com.zmh.demo.util.Constants;
import com.zmh.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time")
public class TimeController {

    @Autowired
    private TimeMapper timeMapper;

    @PostMapping("/times")
    @Transactional
    public Result time(@RequestBody String name){
        QueryWrapper<Time> queryWrapper=new QueryWrapper<Time>();
        String today= DateUtil.today();
        queryWrapper.eq("name",name);
        queryWrapper.eq("time",today);
        if(timeMapper.selectOne(queryWrapper) != null){
            return Result.error(Constants.CODE_401,"今天已签到,请不要重复签到!");
        }else {
            Time time=new Time();
            time.setName(name);
            time.setTime(today);
            timeMapper.insert(time);
            return Result.success("签到成功!");
        }
    }



}
