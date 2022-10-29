package com.zmh.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zmh.demo.enty.Editor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface EditMapper extends BaseMapper<Editor> {

    @Select("Select count(*) from editortest where title like concat('%',#{titleName},'%')")
    Integer total(@Param("titleName") String titleName);

    @Select("Select count(*) from editortest where title = #{title}")
    Integer pass(@Param("title") String title);
}
