package com.phuong.relationship.repository;

import com.phuong.relationship.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog, Long> {

    @Query(value = " select b.* from blog b join category c on b.category_id = c.id " +
            " where b.content like concat('%', :content , '%') and (b.category_id = :categoryId or :categoryId = -1) ",
            nativeQuery = true,
    countQuery = " select count(*) from (select b.* from blog b join category c on b.category_id = c.id " +
            " where b.content like concat('%', :content , '%') and (b.category_id = :categoryId or :categoryId = -1)) temp")
    Page<Blog> getAllBlogPage(Pageable pageable,@Param("content") String content,@Param("categoryId") Integer categoryId);
}
