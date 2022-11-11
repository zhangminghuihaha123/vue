package com.zmh.demo.controller.Front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zmh.demo.interceptor.MyInterFace.AcrossToken;
import com.zmh.demo.mapper.ShopCarMapper;
import com.zmh.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/delete")
    @AcrossToken
    public Result deleteOrder(@RequestBody HashMap map){
        try{
            QueryWrapper wrapper=new QueryWrapper();
            wrapper.eq("user",map.get("user"));
            wrapper.eq("goods",map.get("goods"));
            shopCarMapper.delete(wrapper);
            return Result.success();
        }catch (Exception e){
            return Result.error();
        }
    }
}
