package com.example.data.blogjson.controller;

import com.example.data.blogjson.model.Blog;
import com.example.data.blogjson.model.Category;
import com.example.data.blogjson.service.IBlogService;
import com.example.data.blogjson.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("blogs")
    public ResponseEntity<List<Blog>> findAllBlog() {
        List<Blog> customers = iBlogService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @GetMapping("blogs/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable Integer id){
        Blog blog = iBlogService.findById(id);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
    @GetMapping("category")
    public ResponseEntity<List<Category>> findAllCategory(){
        List<Category> categories = iCategoryService.findAll();
        if (categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);

    }


    @GetMapping("search/{id}")
    public ResponseEntity<List<Blog>> findBlogByCategory(@PathVariable Integer id){
        List<Blog> blogs = iBlogService.findBlogByCategory(id);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }


}
