package com.zmh.demo.service;

import com.zmh.demo.enty.Role;
import com.zmh.demo.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

}
