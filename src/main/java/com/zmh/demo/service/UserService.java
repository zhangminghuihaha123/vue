package com.zmh.demo.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zmh.demo.enty.User;
import com.zmh.demo.mapper.UserMapper;
import com.zmh.demo.util.Constants;
import com.zmh.demo.util.Result;
import com.zmh.demo.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Result login(User user) {
        if(userMapper.todoUserLogin(user.getUsername(),user.getPassword()) != 0){
             String token= TokenUtils.getToken(user.getUsername(),user.getPassword());
             user.setToken(token);
             QueryWrapper wrapper=new QueryWrapper();
             wrapper.eq("username",user.getUsername());
             user.setAvater(userMapper.selectOne(wrapper).getAvater());
             user.setRole(userMapper.getRole(user.getUsername()));
             return Result.success(user);
        }
        return Result.error(Constants.CODE_500,"用户名或密码错误");
    }

    public Result resport(User user) {
        HashMap map=new HashMap();
        for(User user1 : userMapper.SelectQueryUser(map)){
            if(user1.getUsername().equals(user.getUsername())){
                return Result.error(Constants.CODE_500,"未知的错误，可能用户名已存在!");
            }
        }
        userMapper.insert(user);
        return Result.success("用户注册成功!");
    }

    @Transactional
    public Result save(User user) {
        /*判断是否存在该用户*/
        try{
            if(user.getId()!=null && user.getId()!=0){
                QueryWrapper wrapper=new QueryWrapper();
                wrapper.eq("id",user.getId());
                userMapper.update(user,wrapper);
                return Result.success("用户修改完毕!");
            }else {
                userMapper.insert(user);
                return Result.success("用户增加完毕!");
            }
        }catch (Exception e){
            return Result.error();
        }
    }


    @Transactional
    public void saveBath(List<User> list) {
        for(User user: list){
            this.save(user);
        }
    }
}
