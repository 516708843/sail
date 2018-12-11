package com.sail.config;

import com.sail.service.type2.FunctionService2;
import com.sail.service.type2.UseFunctionService2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigForFunctionService2 {

    @Bean
    public FunctionService2 functionService2(){
        return new FunctionService2();
    }

    @Bean
    public UseFunctionService2 useFunctionService2(){
        UseFunctionService2 useService2 = new UseFunctionService2();
        useService2.setService2(functionService2());
        return useService2;
    }


}
