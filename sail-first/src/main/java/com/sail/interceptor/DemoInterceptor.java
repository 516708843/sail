package com.sail.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器，计算每一次请求的处理时间
 */
public class DemoInterceptor extends HandlerInterceptorAdapter {
    /**在请求发生前执行*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return super.preHandle(request, response, handler);
//        return true;
    }
    /**在请求完成后执行*/
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (Long)request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.println("本次请求处理时间为：" + (endTime-startTime)+"ms");
        request.setAttribute("handlingTime",endTime-startTime );
                super.postHandle(request, response, handler, modelAndView);
    }
}
