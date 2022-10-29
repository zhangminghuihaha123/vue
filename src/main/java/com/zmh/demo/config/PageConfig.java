package com.zmh.demo.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.qianhouduan.fenli.mapping")
@EnableTransactionManagement
@Configuration
public class PageConfig {

    /*乐观锁*/
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return  new OptimisticLockerInterceptor();
    }


    /*Mybatis-plus启用分页查询*/
    @Bean
    public PaginationInterceptor paginationInterceptor(){
      PaginationInterceptor  paginationInterceptor=new PaginationInterceptor();
      return paginationInterceptor;
    }
}
