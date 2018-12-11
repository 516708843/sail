package com.sail.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice//声明一个控制器建言
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)//定义全局处理，此处拦截所有Exception
    public ModelAndView exception(Exception exception, WebRequest requets){
        exception.printStackTrace();
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage",exception.getMessage());
        return modelAndView;
    }

    @ModelAttribute//将键值对添加到全局，所有注解了RequestMapping的方法可获得此键值对
    public void addAttributes(Model model){
        model.addAttribute("msg","额外信息");
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
        //此处忽略request参数的id
    }
}
