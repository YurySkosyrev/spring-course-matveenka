package com.dmdev.spring.http.controller;

import com.dmdev.spring.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

@RequestMapping("/app/v1")
@Controller
@SessionAttributes({"user"})
public class GreetingController {

    @GetMapping("/hello")
    public String hello(Model model, HttpServletRequest httpRequest){

        model.addAttribute("user", new UserDto(1, "ures"));

        return "greeting/hello";
    }

    @GetMapping("/hello/{id}")
    public ModelAndView hello2(ModelAndView modelAndView, HttpServletRequest httpRequest,
                              @RequestParam Integer age,
                              @RequestHeader String accept,
                              @CookieValue("JSESSIONID") String jsessionId,
                              @PathVariable("id") Integer id){
        String ageParamValue = httpRequest.getParameter("age");
        String headerParamValue = httpRequest.getHeader("accept");
        Cookie[] cookies = httpRequest.getCookies();

        modelAndView.setViewName("greeting/hello");

        return modelAndView;
    }

    @GetMapping("/bye")
    public String buy(@SessionAttribute("user") UserDto user, Model model){

        return "greeting/bye";
    }
}
