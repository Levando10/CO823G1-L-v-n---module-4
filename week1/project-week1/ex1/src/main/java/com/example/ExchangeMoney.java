package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExchangeMoney {
    @GetMapping
    public ModelAndView showHome(){
        return new ModelAndView("/index");
    }

    @GetMapping("/caculator")
    public ModelAndView exchangeMoney(@RequestParam double rate , @RequestParam double usd){
        double vnd = usd * rate;
        return new ModelAndView("/index","vnd", vnd);
    }
}
