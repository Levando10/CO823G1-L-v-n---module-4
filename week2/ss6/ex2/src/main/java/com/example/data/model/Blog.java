package com.example.data.model;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;




@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]*",message = "just character")
    private String title;
    private String context;
    private String summary;
    private String author;

    private LocalDateTime localDateTime;
    @ManyToOne
    @JoinColumn(name = "c_id")
   private Category category;

    public Blog(Integer id, String title, String context, String summary, String author, Category category) {
        this.id = id;
        this.title = title;
        this.context = context;
        this.summary = summary;
        this.author = author;
        this.category = category;
    }

    public Blog(String title, String context, String summary, String author, LocalDateTime localDateTime, Category category) {
        this.title = title;
        this.context = context;
        this.summary = summary;
        this.author = author;
        this.localDateTime = localDateTime;
        this.category = category;
    }

    public Blog(String title, String context, String summary, String author, Category category) {
        this.title = title;
        this.context = context;
        this.summary = summary;
        this.author = author;
        this.category = category;
    }



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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
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
