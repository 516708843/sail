package com.sail.config;

import com.sail.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc //开启对Spring MVC的配置支持,使重写方法生效
@ComponentScan("com.sail")
public class MvcConfig implements WebMvcConfigurer  {
    //WebMvcConfigurerAdapter弃用，他实现了WebMvcConfigurer接口，用了java8的default

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //浪费我两天，只因少了最后的这个斜杠，啊啊啊啊
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }
    //TODO 静态资源映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addResourceHandler对外暴露的访问路径
        //addResourceLocations文件放置的目录
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    @Bean
    public DemoInterceptor demoInterceptor(){
        return new DemoInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }


}
