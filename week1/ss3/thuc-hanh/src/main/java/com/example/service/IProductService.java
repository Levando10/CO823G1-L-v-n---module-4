package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    boolean save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);

    List<Product> searchByName(String search);
}
