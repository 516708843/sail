package com.sail.service.type2;

public class UseFunctionService2 {

    FunctionService2 service2;

    public void setService2(FunctionService2 service2) {
        this.service2 = service2;
    }

    public String sayHello(String word ){
        return service2.sayHello(word);
    }
}
