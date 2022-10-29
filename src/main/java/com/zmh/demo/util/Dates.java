package com.zmh.demo.util;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class Dates {
    public static void main(String[] args) {
        long date=DateUtil.date().getTime();
        System.out.println(String.valueOf(date));
    }
}
