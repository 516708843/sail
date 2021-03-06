package com.sail.controller;

import com.sail.domain.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class DemoRestController {

    @RequestMapping(value = "/getjson",produces = {"application/json;charset=UTF-8"})
    public DemoObj getJson(DemoObj obj){
        System.out.println("*****obj"+obj);
        return new DemoObj(obj.getId()+1,obj.getName()+"yy");
    }

    @RequestMapping(value = "/getxml",produces = {"application/xml;charset=UTF-8"})//需要依赖第三方支持支持
    public DemoObj getXml(DemoObj obj){
        return new DemoObj(obj.getId() +1 ,obj.getName()+"yy");
    }

}
