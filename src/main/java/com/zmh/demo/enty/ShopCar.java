package com.zmh.demo.enty;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("shopcar")
public class ShopCar {

    @TableId(type=IdType.AUTO,value = "id")
    private Integer id;

    @TableField("goods")
    private String goods;

    @TableField("price")
    private Integer price;

    @TableField("total")
    private Integer total;

    @TableField("user")
    private String user;

    @TableField("time")
    private String time;

    @TableField("num")
    private Integer num;
}
