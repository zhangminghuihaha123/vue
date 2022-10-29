package com.zmh.demo.interceptor;

import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class WebInterceptor implements HandlerInterceptor {

    @Autowired
    private static final Log log=  Log.get();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        /*不是映射方法直接通过*/
        if(!(handler instanceof HandlerMethod)){
            log.info("直接通过");
            return true;
        }

        if(StrUtil.isBlank(token)  || token.equals("undefined")){
            log.info("拦截+++++++++++++++>"+token);
            return false;
        }

        log.info("token================>"+token);
        return true;
    }
}
