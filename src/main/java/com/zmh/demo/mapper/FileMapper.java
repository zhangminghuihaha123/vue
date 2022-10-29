package com.zmh.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zmh.demo.enty.Files;
import org.apache.commons.compress.compressors.gzip.GzipParameters;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface FileMapper extends BaseMapper<Files> {

    public List<Files> QueryListFile(HashMap map);

    @Select("Select count(*) from files where filename like concat('%',#{filename},'%')")
    public Integer QueryFileNUm(@Param("filename") String filename);

    @Select("Select * from files where id = #{id}")
    Files selectId(@Param("id") Integer id);

    @Select("Select avater from files AS a WHERE a.`check`=1 AND (type= 'png' or type= 'jpg' or type= 'gif')")
    List<String> SelectThingsFile();

    void updateCheck(@Param("i") int i,@Param("id") Integer id);
}
