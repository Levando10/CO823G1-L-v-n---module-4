package com.example.repository;

import com.example.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository{
    private static List<Customer> list = new ArrayList<>();

    static {
        list.add(new Customer(1,"độ","lớp 10"));
        list.add(new Customer(2,"bảo","lớp 12"));
        list.add(new Customer(3,"dũng","lớp 11"));
    }


    @Override
    public List<Customer> getAll() {
        return list;
    }
}
