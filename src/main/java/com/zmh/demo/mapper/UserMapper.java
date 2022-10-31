package com.zmh.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zmh.demo.enty.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    public List<User> SelectQueryUser(HashMap map);

    @Select("Select count(*) from second where username=#{username} and password=#{password}")
    public Integer todoUserLogin(@Param("username") String username,@Param("password") String password);

    @Select("Select count(*) from second where username like concat('%',#{username},'%')")
    Integer todoSize(@Param("username") String username);

    @Select("Select role from second where username =#{username} limit 0,1")
    String getRole(@Param("username") String username);


    List<HashMap<String,Object>> set();
}
