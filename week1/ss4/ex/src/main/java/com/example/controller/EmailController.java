package com.example.controller;

import com.example.model.EmailBox;
import com.example.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {

    @RequestMapping("/")
    public ModelAndView home(){
        EmailBox emailBox = iMailBoxService.showEmail();
        return new ModelAndView("/index","email",emailBox);
    }

    @Autowired
    IMailBoxService iMailBoxService;

    @ModelAttribute("languages")
    public String[] getLanguage(){
        return iMailBoxService.showLanguage();
    }
    @ModelAttribute("sizes")
    public int[] getSize(){
        return iMailBoxService.showSize();
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("email") EmailBox emailBox , RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("mess","update mail success!!!");
        iMailBoxService.update(emailBox);
        return "redirect:/";
    }






}
