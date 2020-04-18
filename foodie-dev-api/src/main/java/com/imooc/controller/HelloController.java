package com.imooc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public  Object hello(){
        Map map=new HashMap();
        return  "hello world~";
    }
}
