package com.zmh.demo.interceptor.MyInterFace;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AcrossToken {
}
