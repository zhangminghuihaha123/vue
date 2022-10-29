package com.zmh.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfig {

    /*注入一个ServletEndpointExporter，该Bean会自动注册使用@ServerEndpoint注解*/
    /*开启聊天类型的集成*/
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }

}
