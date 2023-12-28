package com.phuong.repository;

import com.phuong.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = " select * from product where name like :searchValue ", nativeQuery = true)
    Page<Product> findByKeyword(Pageable pageable,@Param("searchValue") String searchValue);
}
