package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CaculatorController {
    @RequestMapping("/")
    public String home(){
        return "/home";
    }

    @PostMapping("/caculator")
    public ModelAndView handleCaculator(@RequestParam(name = "first") double first,@RequestParam(name = "second") double second,@RequestParam("calculate") String calculate  ){
        ModelAndView modelAndView = new ModelAndView("/home");
        double result;
        if ((second == 0.0) && calculate.equals("/") ){
            String mess = "Không thể chia cho 0!!!";
            modelAndView.addObject("mess",mess);
            return modelAndView;
        }else {
            switch (calculate){
                case "+":
                    result = first + second;
                    break;
                case "-":
                    result = first - second;
                    break;
                case "*":
                    result = first * second;
                    break;
                default:
                    result = first / second;
            }

        }
        modelAndView.addObject("result",result);

        return modelAndView;
    }
}
