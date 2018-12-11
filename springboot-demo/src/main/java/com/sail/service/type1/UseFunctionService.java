package com.sail.service.type1;

import com.sail.service.type1.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseFunctionService{

    @Autowired
    FunctionService functionservice;

    public String sayHello(String word){
        return functionservice.sayHello(word);
    }

}
