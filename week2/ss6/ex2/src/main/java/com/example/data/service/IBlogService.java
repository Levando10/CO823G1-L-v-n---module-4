package com.example.data.service;

import com.example.data.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {


    Iterable<Blog> findAll();

    void remove(Integer id);

    Blog findById(Integer id);

    void save(Blog blog);
    Page<Blog> findAll(Pageable pageable);

    List<Blog> findByName(String name);
}
