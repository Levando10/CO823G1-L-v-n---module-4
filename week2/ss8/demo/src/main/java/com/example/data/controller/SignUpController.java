package com.example.data.controller;

import com.example.data.model.SignUp;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class SignUpController {
    @GetMapping
    public String homeSignUp(){
        return "/form-sign-up";
    }
    @ModelAttribute("OSignUp")
    public SignUp signUp(){
        return new SignUp();
    }

    @PostMapping("/check")
    public ModelAndView checkSignUp(@Valid @ModelAttribute("OSignUp")SignUp signUp, BindingResult bindingResult){

        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/form-sign-up");
        }
        return new ModelAndView("/success");
    }

}
