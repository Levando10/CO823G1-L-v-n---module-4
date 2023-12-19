package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public ModelAndView greeting(@RequestParam String name, Model model){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("name",name);
        model.addAttribute("name",name);
        return modelAndView;
    }
}
