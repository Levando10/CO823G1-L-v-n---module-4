package com.example.data.repository;

import com.example.data.model.Blog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends CrudRepository<Blog, Integer>, PagingAndSortingRepository<Blog,Integer> {
    @Query(value = "select * from blog where blog.title like :name",nativeQuery = true)
    List<Blog> findByName(@Param("name") String name);

}
