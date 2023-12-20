package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class HomeController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;

    public HomeController() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }
    @GetMapping("/")
    public String home(){
        return "/home";
    }
    @RequestMapping(value = "/validate",method = RequestMethod.POST)
    public ModelAndView handleEmail(@RequestParam("email") String email){
        ModelAndView modelAndView = new ModelAndView();
        boolean checkEmail = validate(email);
        modelAndView.setViewName( "/home");
        if (checkEmail){
            modelAndView.addObject("message", "Email is Success");
            return modelAndView;
        }else{
            modelAndView.addObject("message", "Email is invalid");
            return modelAndView;
        }

    }
    private boolean validate(String regex) {
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
