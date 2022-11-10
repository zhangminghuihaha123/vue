package com.zmh.demo.controller.Front;

import com.zmh.demo.interceptor.MyInterFace.AcrossToken;
import com.zmh.demo.mapper.ShopCarMapper;
import com.zmh.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private ShopCarMapper shopCarMapper;

    @GetMapping("/get")
    @AcrossToken
    public Result getUserOrder(@RequestParam String username){
        List<HashMap<String,Object>> list=shopCarMapper.getOneOrders(username);
        return Result.success(list);
    }
}
