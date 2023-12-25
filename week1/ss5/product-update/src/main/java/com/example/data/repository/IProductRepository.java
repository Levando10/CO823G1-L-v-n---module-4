package com.example.data.repository;

import com.example.data.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);


    void remove(int id);

    List<Product> searchByName(String search);
}