package com.zmh.demo.enty;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("time")
public class Time {

    @TableId(type = IdType.AUTO,value = "id")
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("time")
    private String time;
}
