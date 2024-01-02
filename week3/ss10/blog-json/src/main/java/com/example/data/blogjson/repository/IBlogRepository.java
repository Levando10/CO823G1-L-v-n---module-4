package com.example.data.blogjson.repository;

import com.example.data.blogjson.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer>,CrudRepository<Blog,Integer> {
    @Query(value = "select * from blog where blog.title like ?1",nativeQuery = true)
    List<Blog> findAllByName(@Param("name") String name);

//    @Query(value = "select * from blog where blog.c_id = ?1",nativeQuery = true) @Param("c_id")
    List<Blog>findAllByCategory_Id(Integer id);
    Page<Blog> findAllByOrderByLocalDateTimeDesc( Pageable pageable);
    List<Blog>findBlogsByCategory_Id(Integer id);

}
