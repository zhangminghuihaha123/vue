package com.zmh.demo.util;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Wan {

    public Integer randoms(){
        Random random=new Random();
        return random.nextInt(10000);
    }

    public Integer cai(){
        System.out.println("请输入您猜测的下一位数字!========>");
        Scanner in=new Scanner(System.in);
        return in.nextInt();
    }

    public static void main(String[] args) {
        Wan wan=new Wan();
        int sum=wan.randoms();
        int n=0;
        while (true){
            n+=1;
            int cai=wan.cai();
            if(cai>sum){
                System.out.println("大了");
            }
            if(cai<sum){
                System.out.println("小了");
            }
            if(cai == sum){
                System.out.println("猜对了!,您猜了"+n+"次");
                break;
            }
        }
    }
}
