package com.zmh.demo.util;


public class CardToCheck {

    public static String todo(String  hope){
        char[] chars=hope.toCharArray();
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<hope.length();i++){
            if(!(i==0 || i==hope.length()-1)){
                stringBuilder.append(chars[i]);
            }
        }
        return stringBuilder.toString();
    }
}
