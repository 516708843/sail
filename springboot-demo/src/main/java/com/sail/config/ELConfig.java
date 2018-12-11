package com.sail.config;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import sun.nio.ch.IOUtil;

import java.io.IOException;

@Configuration
@ComponentScan("com.sail")
@PropertySource("classpath:root.properties")
public class ELConfig {


    @Value("#{systemProperties['os.name']}")
    private String osName;

    @Value("#{T(java.lang.Math).random()*11}")
    private double randomNumer;

    @Value("#{root.lenth}")//取类属性
    private int length;

    @Value("#{root.age}")
    private int age;

    @Value("#{root.name}")//取类属性？？
    private String name;
    @Value("${root.name}")//取配置文件？？
    private String name2;

    @Value("classpath:banner.txt")
    private Resource bannerFile;

    @Value("Http://www.baidu.com")
    private Resource testUrl;

    @Autowired
    Environment environment;

    @Bean
    public static ConfigForAnnotation configForAnnotation(){
        return new ConfigForAnnotation();
    }

    public void outputResource(){
        try{
            System.out.println(osName);
            System.out.println(randomNumer);
            System.out.println(length);
            System.out.println(age);
            System.out.println(name);
            System.out.println(name2);
            System.out.println(IOUtils.toString(bannerFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
            System.out.println(environment.getProperty("server.port"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
