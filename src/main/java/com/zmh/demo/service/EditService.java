package com.zmh.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zmh.demo.enty.Editor;
import com.zmh.demo.mapper.EditMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditService {

    @Autowired
    private EditMapper editMapper;

    public void save(Editor editor) {
        if(editMapper.pass(editor.getTitle()) > 0){
            QueryWrapper wrapper=new QueryWrapper();
            wrapper.eq("title",editor.getTitle());
            editMapper.update(editor,wrapper);
        }else {
            editMapper.insert(editor);
        }
    }
}
