package com.phuong.relationship.service.impl;

import com.phuong.relationship.model.Blog;
import com.phuong.relationship.repository.IBlogRepository;
import com.phuong.relationship.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public Page<Blog> findAll(Pageable pageable, String content, Integer categoryId) {
        return this.blogRepository.getAllBlogPage(pageable, content, categoryId);
    }
}
