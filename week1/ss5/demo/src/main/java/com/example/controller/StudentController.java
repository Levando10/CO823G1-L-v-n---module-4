package com.example.controller;

import com.example.model.Student;
import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("students", studentService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createGet() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }


//    @GetMapping("/update/{id}")
//    public ModelAndView updateGet(@PathVariable Long id) {
//        Student student = studentService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("/update");
//        if (student != null) {
//            modelAndView.addObject("student", student);
//        } else {
//            modelAndView.addObject("message", "Khong tim thay Student tuong ung");
//        }
//        return modelAndView;
//    }

}
