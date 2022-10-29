package com.zmh.demo.service;

import com.zmh.demo.mapper.FileMapper;
import com.zmh.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private FileMapper fileMapper;

    @Value("${files.upload.path}")
    private String Filepath;

    public Result delete(Integer id) {
        if(id != 0){
            /*不仅要删除数据库信息，也要删除文件*/
            String filename=fileMapper.selectId(id).getFilename();
            File file=new File(Filepath+filename);
            if(file.exists()){
                file.delete();
            }

            fileMapper.deleteById(id);

            return Result.success("删除成功!");
        }
        return Result.error();
    }

    public Result deletes(List<Integer> ids) {
        if(ids.size() != 0){
            for(int i=0;i<ids.size();i++){
                this.delete(ids.get(i));
            }
            return Result.success("删除成功!");
        }
        return Result.error();
    }
}
