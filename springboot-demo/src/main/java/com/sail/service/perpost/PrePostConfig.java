package com.sail.service.perpost;

import org.springframework.context.annotation.Bean;

public class PrePostConfig {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    BeanWayService beanWayService(){
        return new BeanWayService();
    }

    @Bean
    JSR250WayService jsr250WayService(){
        return new JSR250WayService();
    }

}
