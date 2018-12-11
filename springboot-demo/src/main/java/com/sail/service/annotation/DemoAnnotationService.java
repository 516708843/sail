package com.sail.service.annotation;

import com.sail.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class DemoAnnotationService {
    @Action(name="注解式拦截的add操作")
    public void add(){
        System.out.println("add()");
    }
}
