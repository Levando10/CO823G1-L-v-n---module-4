package com.phuong.service;

import com.phuong.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> findAll(Pageable pageable, String searchValue);

    List<Product> findAll();

    void remove(Integer id);

    void save(Product product);

    Product getById(Integer id);
}
