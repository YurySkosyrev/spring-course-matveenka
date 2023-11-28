package com.dmdev.spring.http.controller;

import org.springframework.web.servlet.ModelAndView;

public class GreetingController {

    public ModelAndView hello(ModelAndView modelAndView){
        modelAndView.setViewName("greeting/hello");

        return modelAndView;
    }

    public ModelAndView buy(ModelAndView modelAndView){
        modelAndView.setViewName("greeting/buy");

        return modelAndView;
    }
}
