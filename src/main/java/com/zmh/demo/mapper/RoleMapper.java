package com.zmh.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zmh.demo.enty.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface RoleMapper extends BaseMapper<Role> {


    @Select("Select count(*) from role")
    Integer total();

    @Select("Select role from role")
    List<String> togetRole();
}
