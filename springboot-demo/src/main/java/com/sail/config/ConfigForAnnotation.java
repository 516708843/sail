package com.sail.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.sail")
@EnableAspectJAutoProxy//开启Spring对AspectJ代理的支持
public class ConfigForAnnotation {

}
