package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;



@Component
public class WelcomeMessage {

    Logger log = LoggerFactory.getLogger(WelcomeMessage.class);
    String msg = "Welcom Moter Fuckers";

    public WelcomeMessage(String msg){
        this.msg = msg;
    }

    public WelcomeMessage(){
        MDC.put("requestId", "11111111122222222222222");
        System.out.println(msg);
        log.error("YEEEET");
    }


}
