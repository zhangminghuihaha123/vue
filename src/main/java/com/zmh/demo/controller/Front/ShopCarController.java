package com.zmh.demo.controller.Front;

import cn.hutool.core.date.DateUtil;
import com.zmh.demo.enty.ShopCar;
import com.zmh.demo.interceptor.MyInterFace.AcrossToken;
import com.zmh.demo.mapper.ShopCarMapper;
import com.zmh.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ShopCarController {

    @Autowired
    private ShopCarMapper shopCarMapper;


    @PostMapping("/insert")
    @AcrossToken
    public Result toShopCar(@RequestBody ShopCar shopCar){
        try{
            shopCar.setTime(DateUtil.today());
            shopCarMapper.insert(shopCar);
            return Result.success();
        }catch (Exception e){
            return Result.error();
        }
    }
}
