package com.sail.mvcDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @RequestMapping("/index")
    public String hello(){
        return "index";
    }

}
