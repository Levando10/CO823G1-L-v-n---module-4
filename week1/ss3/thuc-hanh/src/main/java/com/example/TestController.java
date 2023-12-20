package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/test");
        String name = "Lê Văn Độ";
        String classes = "C0823G1";
        modelAndView.addObject("name",name);
        modelAndView.addObject("classes",classes);

        return modelAndView;
    }
}
