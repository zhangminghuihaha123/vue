package com.zmh.demo.interceptor;

import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import com.zmh.demo.interceptor.MyInterFace.AcrossToken;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class WebInterceptor implements HandlerInterceptor {

    @Autowired
    private static final Log log=  Log.get();

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        /*不是映射方法直接通过*/
        if(!(handler instanceof HandlerMethod)){
            log.info("直接通过");
            return true;
        }

        /*查看是否被注解修饰*/
        AcrossToken acrossToken= ((HandlerMethod) handler).getMethodAnnotation(AcrossToken.class);
        if (acrossToken != null){
            log.info("注解通过");
            return true;
        }

        if(StrUtil.isBlank(token)  || token.equals("undefined")){
            log.info("拦截+++++++++++++++>"+token);
            return false;
        }

        log.info("token================>"+token);
        redisTemplate.opsForValue().set("token:"+token,token,30, TimeUnit.MINUTES);
        return true;
    }
}
