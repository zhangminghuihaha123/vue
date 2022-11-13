package com.zmh.demo.enty.DTO;

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
@TableName("alipay")
public class AliPayDto {

    @TableId(type = IdType.AUTO,value = "id")
    private Integer id;

    @TableField("ordertoken")
    private String orderToken;

    @TableField("time")
    private String time;
}
