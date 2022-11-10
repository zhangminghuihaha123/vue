package com.zmh.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zmh.demo.enty.ShopCar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface ShopCarMapper extends BaseMapper<ShopCar> {

    List<HashMap<String, Object>> getOneOrders(@Param("username") String username);
}
