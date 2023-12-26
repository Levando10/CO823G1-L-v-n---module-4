package com.example.data.controller;


import com.example.data.model.Blog;
import com.example.data.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @ModelAttribute("blog")
    public Blog blog(){
        return new Blog();
    }


    @RequestMapping
    public ModelAndView findAll(@PageableDefault(value = 5)Pageable pageable){
//        Iterable<Blog> list = iBlogService.findAll();
        Page<Blog> list = iBlogService.findAll(pageable);
        return new ModelAndView("/home","list",list);
    }
    @GetMapping("/deleteBlog")
    public String handleDelete(@RequestParam("id") Integer id){
        iBlogService.remove(id);
        return "redirect:/";
    }
    @GetMapping("{id}/detail")
    public String viewProduct(@PathVariable Integer id, Model model){

        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog",blog);
        return "/detail";
    }
    @GetMapping("/createBlog")
    public String handleCreate(@ModelAttribute("blog") Blog blog){
        iBlogService.save(blog);

        return "redirect:/";
    }
    @PostMapping("/updateBlog")
    public String handleUpdate(
            @RequestParam("idEdit") Integer id,
            @RequestParam("title") String title,
            @RequestParam("context") String context,
            @RequestParam("author") String author,
            @RequestParam("summary") String summary
    ){
        Blog blog = iBlogService.findById(id);
        blog.setContext(context);
        blog.setAuthor(author);
        blog.setSummary(summary);
        blog.setTitle(title);
        iBlogService.save(blog);
        return "redirect:/";
    }

    @PostMapping("/search")
    public ModelAndView searchByName(@RequestParam("name-search") String name){
        List<Blog> list = iBlogService.findByName(name);
        ModelAndView modelAndView  = new ModelAndView("/search");
        modelAndView.addObject("list",list);

        return modelAndView;
    }


}
