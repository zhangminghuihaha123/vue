package com.zmh.demo.controller.Front;

import com.zmh.demo.mapper.FileMapper;
import com.zmh.demo.service.FileService;
import com.zmh.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/front")
public class FrontController {

    @Autowired
    private FileMapper fileMapper;

    @Autowired
    private FileService fileService;

    @GetMapping("/getimg")
    public Result getImg(){
        try{
            return Result.success(fileMapper.SelectThingsFile());
        }catch (Exception e){
            return Result.error();
        }
    }

}
