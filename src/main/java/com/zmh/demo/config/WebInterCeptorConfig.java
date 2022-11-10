package com.zmh.demo.config;

import com.zmh.demo.interceptor.WebInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebInterCeptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        List list=new ArrayList();
        list.add("/login");
        list.add("/resport");
        list.add("/user/export");
        list.add("/user/import");
        list.add("/user/selectone/**");
        list.add("/user/set");
        list.add("/file/upload");
        list.add("/file/getimg");
        list.add("/file/img/**");
        list.add("/file/delete/**");
        list.add("/file/bol");
        list.add("/file/delete");
        list.add("/role/save");
        list.add("/role/delete/**");
        list.add("/role/delete");
        list.add("/role/toget");
        list.add("/file/editorImg");
        list.add("/alipay/**");


        /*拦截所有请求，判断token是否合法*/
        registry.addInterceptor(webInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(list);
    }

    @Bean
    public WebInterceptor webInterceptor(){
        return new WebInterceptor();
    }

}
