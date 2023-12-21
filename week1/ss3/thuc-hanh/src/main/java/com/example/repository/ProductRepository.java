package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static final Map<Integer, Product> list;
    static {
        list = new HashMap<>();
        list.put(1, new Product(1, "Xe Đạp",1000, "Xe đạp xịn","Honda"));
        list.put(2, new Product(2, "Xe Máy",30000, "Xe Máy xịn","Honda"));
        list.put(3, new Product(3, "Xe Máy Điện",22000, "Xe vin","Vìn"));
        list.put(4, new Product(4, "Xe Đạp Điện",10000, "Xe đạp điện vip nhất","Tesla"));
        list.put(5, new Product(5, "Ô Tô",57000, "BMW","BMW"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(list.values());
    }

    @Override
    public boolean save(Product product) {
        if (list.containsKey(product.getId())){
            return false;
        } else {
            list.put(product.getId(), product);
            return true;
        }
    }

    @Override
    public Product findById(int id) {
        return list.get(id);
    }

    @Override
    public void update(int id, Product product) {
        list.put(id, product);
    }

    @Override
    public void remove(int id) {
        list.remove(id);

    }

    @Override
    public List<Product> searchByName(String search) {
        System.out.println(search);
        List<Product> productList = new ArrayList<>(list.values());
        List<Product> listSearch = new ArrayList<>();
        for (Product product : productList){
            if (product.getName().toLowerCase().contains(search.trim().toLowerCase())){
                listSearch.add(product);
            }
        }

        return listSearch;
    }
}
