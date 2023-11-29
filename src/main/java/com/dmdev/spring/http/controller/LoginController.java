package com.dmdev.spring.http.controller;

import com.dmdev.spring.dto.LoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin(){
        return "user/login";
    }

    @PostMapping("/login")
    public String postLogin(Model model, @ModelAttribute("user") LoginDto loginDto){
        return "user/login";
    }
}