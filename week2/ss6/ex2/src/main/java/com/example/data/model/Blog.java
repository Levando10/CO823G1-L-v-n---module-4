package com.example.data.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String context;
    private String summary;
    private String author;

    public Blog() {
    }

    public Blog(Integer id, String title, String context, String summary , String author) {
        this.id = id;
        this.title = title;
        this.context = context;
        this.summary = summary;
        this.author = author;
    }

    public Blog(String title, String context, String summary , String author) {
        this.title = title;
        this.context = context;
        this.summary = summary;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
