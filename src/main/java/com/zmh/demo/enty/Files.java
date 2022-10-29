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
@TableName("files")
public class Files {

    @TableId(type = IdType.AUTO,value = "id")
    private Integer id;

    @TableField("filename")
    private String filename;

    @TableField("type")
    private String type;

    @TableField("size")
    private Long size;

    @TableField("avater")
    private String avater;

    @TableField("check")
    private Boolean check;
}
