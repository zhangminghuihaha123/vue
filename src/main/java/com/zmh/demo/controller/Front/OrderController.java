package com.zmh.demo.controller.Front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zmh.demo.controller.Alipay.AliPayController;
import com.zmh.demo.interceptor.MyInterFace.AcrossToken;
import com.zmh.demo.mapper.AliPayMapper;
import com.zmh.demo.mapper.ShopCarMapper;
import com.zmh.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private ShopCarMapper shopCarMapper;

    @Autowired
    private AliPayMapper aliPayMapper;

    @GetMapping("/get")
    @AcrossToken
    public Result getUserOrder(@RequestParam String username){
        List<HashMap<String,Object>> list=shopCarMapper.getOneOrders(username);
        return Result.success(list);
    }

    @PostMapping("/delete")
    @AcrossToken
    @Transactional
    public Result deleteOrder(@RequestBody HashMap map){
        try{
            QueryWrapper wrapper=new QueryWrapper();
            wrapper.eq("user",map.get("user"));
            wrapper.eq("goods",map.get("goods"));
            shopCarMapper.delete(wrapper);
            return Result.success();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    @PostMapping("/session")
    @AcrossToken
    public Result OrderSeesion(@RequestBody String trade){
        System.out.println(trade);
        if(aliPayMapper.selectByTrade(trade) != 0){
            /*每当付款获取成功，写入数据库，需要MYSQL定时器来管理删除非当日的数据*/
            /*定时器不需要保留之前的数据节点，只需要保留表的结构,trancate删除数据*/
            return Result.success();
        }else {
            return Result.error();
        }
    }

}
