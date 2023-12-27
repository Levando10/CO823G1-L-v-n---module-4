package com.example.data.service;

import com.example.data.model.Blog;
import com.example.data.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void remove(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return  iBlogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findByName(String name) {
        return iBlogRepository.findAllByName("%" + name + "%");
    }

    @Override
    public List<Blog> findByCategory(Integer id) {
        return iBlogRepository.findAllByCategory_Id(id);
    }

    @Override
    public Page<Blog> findAllByOrderByLocalDateTime(Pageable pageable) {
        return iBlogRepository.findAllByOrderByLocalDateTimeDesc(pageable);
    }
}
