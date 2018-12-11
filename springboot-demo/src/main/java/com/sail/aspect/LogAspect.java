package com.sail.aspect;

import com.sail.annotation.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(com.sail.annotation.Action)")
    public void annotationPointCut(){
        System.out.println("annotationPointCut()");//可以观察到不会被执行，仅仅当作一个ref链接作为切入点的注解
    };

    @After("annotationPointCut()")
    public void annotationAfter(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("after: "+ action.name());
    }

    @Before("annotationPointCut()")
    public void annotationBefore(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("before:"+action.name());
    }

    @After(value = "execution(* com.sail.service.annotation.DemoMethodService.*(..))")
    public void after(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则拦截，"+method.getName()+"执行前");
    }

    @Before(value = "execution(* com.sail.service.annotation.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则拦截，"+method.getName()+"执行后");
    }
}
