package com.example.data.blogjson.service;

import com.example.data.blogjson.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {


    List<Blog> findAll();

    void remove(Integer id);

    Blog findById(Integer id);

    void save(Blog blog);
    Page<Blog> findAll(Pageable pageable);

    List<Blog> findByName(String name);

    List<Blog> findByCategory(Integer id);

    Page<Blog> findAllByOrderByLocalDateTime(Pageable pageable);

    List<Blog> findBlogByCategory(Integer id);
}
