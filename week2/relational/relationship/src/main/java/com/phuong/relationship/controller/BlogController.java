package com.phuong.relationship.controller;

import com.phuong.relationship.model.Blog;
import com.phuong.relationship.model.Category;
import com.phuong.relationship.repository.ICategoryRepository;
import com.phuong.relationship.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryRepository categoryRepository;

    @ModelAttribute("categories")
    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    @GetMapping("")
    public String getAllBlogs(Model model,
                              @RequestParam(value = "page", defaultValue = "0") Integer page,
                              @RequestParam(value = "size", defaultValue = "2") Integer size,
                              @RequestParam(value = "content", required = false, defaultValue = "") String content,
                              @RequestParam(value = "categoryId", required = false, defaultValue = "-1") Integer categoryId,
                              @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy,
                              @RequestParam(value = "sortDirection", required = false, defaultValue = "ASC") String sortDirection) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.valueOf(sortDirection), sortBy);
        Page<Blog> blogs = this.blogService.findAll(pageable, content, categoryId);
        model.addAttribute("content", content);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("blogs", blogs);
        return "/list";
    }
}
