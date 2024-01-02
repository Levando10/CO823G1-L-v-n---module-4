package com.example.data.blogjson.controller;


import com.example.data.blogjson.model.Blog;
import com.example.data.blogjson.model.Category;
import com.example.data.blogjson.service.IBlogService;
import com.example.data.blogjson.service.ICategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("blog")
    public Blog blog(){
        return new Blog();
    }


    @RequestMapping("")
    public ModelAndView findAll( @RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "size", defaultValue = "4") Integer size){
//        Iterable<Blog> list = iBlogService.findAll();
        Pageable pageable = PageRequest.of(page, size);
        ModelAndView modelAndView = new ModelAndView("/home");
        Page<Blog> list = iBlogService.findAll(pageable);
        List<Category> cList = iCategoryService.findAll();
        modelAndView.addObject("cList",cList);
        modelAndView.addObject("list",list);
       return modelAndView;
    }
    @GetMapping("/sort")
    public ModelAndView sortAll(@PageableDefault(value = 5)Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("/home");
        Page<Blog> list = iBlogService.findAllByOrderByLocalDateTime(pageable);
        List<Category> cList = iCategoryService.findAll();
        modelAndView.addObject("cList",cList);
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    @GetMapping("/deleteBlog")
    public String handleDelete(@RequestParam("id") Integer id){
        iBlogService.remove(id);
        return "redirect:/";
    }
    @GetMapping("/detail")
    public String viewProduct(@RequestParam ("id") Blog blog, Model model){

//        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog",blog);
        return "/detail";
    }
    @GetMapping("/createBlog")
    public ModelAndView handleCreate(@Valid @ModelAttribute("blog") Blog blog , BindingResult bindingResult){
        System.out.println(blog.getCategory().getName());
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        blog.setLocalDateTime(LocalDateTime.now());
        if (bindingResult.hasErrors()){
        return modelAndView;
        }

        iBlogService.save(blog);

        return modelAndView;
    }
    @PostMapping("/updateBlog")
    public String handleUpdate(
            @RequestParam("idEdit") Integer id,
            @RequestParam("title") String title,
            @RequestParam("context") String context,
            @RequestParam("author") String author,
            @RequestParam("summary") String summary,
            @RequestParam("cate") Category category
    ){
        Blog blog = iBlogService.findById(id);
        blog.setContext(context);
        blog.setAuthor(author);
        blog.setSummary(summary);
        blog.setTitle(title);
        blog.setCategory(category);
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
    @PostMapping("/searchByCategory")
    public ModelAndView searchByCategory(@RequestParam("cate") Category category){
        List<Blog> list = iBlogService.findByCategory(category.getId());
        return new ModelAndView("/search-category","list",list);
    }


}
