package com.zmh.demo.controller;

import com.github.pagehelper.PageHelper;
import com.zmh.demo.enty.User;
import com.zmh.demo.service.UserService;
import com.zmh.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result tologin(@RequestBody User user){
        return userService.login(user);
    }

    @PostMapping("/resport")
    public Result toresport(@RequestBody User user){
         return userService.resport(user);
    }
}
