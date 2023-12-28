package com.phuong.relationship.service;

import com.phuong.relationship.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable, String content, Integer categoryId);
}
