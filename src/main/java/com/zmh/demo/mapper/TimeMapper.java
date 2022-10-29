package com.zmh.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zmh.demo.enty.Time;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TimeMapper extends BaseMapper<Time> {

}
