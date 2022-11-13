package com.zmh.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zmh.demo.enty.DTO.AliPayDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AliPayMapper extends BaseMapper<AliPayDto> {

    @Select("Select count(1) from alipay where ordertoken = #{trade}")
    Integer selectByTrade(@Param("trade") String trade);
}
