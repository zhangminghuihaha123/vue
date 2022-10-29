package com.zmh.demo.enty;

import lombok.Data;

@Data
public class Alipay {
    private String traceNo;
    private Double totalAmount;
    private String subject;
    private String alipayTraceNo;
}

