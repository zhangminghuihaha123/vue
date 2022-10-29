package com.zmh.demo.util;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zmh.demo.enty.User;
import com.zmh.demo.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;

@Component
public class TokenUtils {

    private static UserService staticuserService;

    @Resource
    private UserService userService;

    /*    @PostConstruct是Java自带的注解，在方法上加该注解会在项目启动的时候执行该方法，也可以理解为在spring容器初始化的时候执行该方法。*/
    @PostConstruct
    public void setUserService(){
        staticuserService=userService;
    }

    public static String getToken(String userID,String password){
        /*.withExpiresAt(DateUtil.offsetHour(new Date(),2))*/
        /*把USERID作为载荷保存在token中，2小时过期,最后以password作为密钥*/
       return JWT.create().withAudience(userID).withExpiresAt(DateUtil.offsetHour(new Date(),2)).sign(Algorithm.HMAC256(password));
    }

    /*获取当前登录用户*/
    /*这里static静态方法不能引入非静态和通过spring依赖注入的方式，通过注入赋值给静态，在引入到静态方法中去*/
    public static User getCurrentUser(){
        HttpServletRequest request= ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
         String token=request.getHeader("token");
         if(token != null){
             try{
                 String USERID=JWT.decode(token).getAudience().get(0);
                 HashMap map=new HashMap();
                 map.put("name",USERID);
                 /*这里得改*/
                 return null;
             }catch (Exception e){
                 return null;
             }
         }
         return null;
    }

}
