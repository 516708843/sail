package com.sail.controller;

import com.sail.domain.DemoObj;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class AdviceController {

    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, DemoObj obj){
        throw new IllegalArgumentException("非常抱歉，参数有误/"+"来自@ModelAttribute：" + msg);
    }

}
