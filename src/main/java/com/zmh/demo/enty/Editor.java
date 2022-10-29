package com.zmh.demo.enty;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("editortest")
public class Editor {

    @TableId(type = IdType.AUTO,value = "id")
    private Integer id;

    @TableField("title")
    private String  title;

    @TableField("avater")
    private String avater;

    @TableField("test")
    private String test;

    @TableField("time")
    private Date time;
}
