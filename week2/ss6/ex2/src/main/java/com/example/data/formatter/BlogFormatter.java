package com.example.data.formatter;

import java.text.ParseException;
import java.util.Locale;

import com.example.data.model.Blog;
import com.example.data.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Controller;

@Controller
public class BlogFormatter implements Formatter<Blog> {
    @Autowired
    private IBlogService iBlogService;
    public BlogFormatter(IBlogService iBlogService) {
        this.iBlogService = iBlogService;
    }

    @Override
    public Blog parse(String id, Locale locale) throws ParseException {
    return iBlogService.findById(Integer.parseInt(id));

    }


    @Override
    public String print(Blog object, Locale locale) {
        return null;
    }
}
