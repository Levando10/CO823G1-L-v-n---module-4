package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SanwichController {

    @RequestMapping("/")
    public String home(){
        return "/home";
    }
    @PostMapping("/condiment")
    public ModelAndView handle(@RequestParam(name = "condiment",required = false,defaultValue = "Không lựa chọn gia vị!") String[] arr){
        ModelAndView modelAndView = new ModelAndView("/result");
            modelAndView.addObject("condiment",arr);
            return modelAndView;


    }
}
