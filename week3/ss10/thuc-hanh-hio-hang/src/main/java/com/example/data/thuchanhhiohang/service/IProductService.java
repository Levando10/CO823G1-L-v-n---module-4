package com.example.data.thuchanhhiohang.service;

import com.example.data.thuchanhhiohang.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Integer id);
}
