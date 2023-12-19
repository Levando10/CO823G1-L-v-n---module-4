package com.example.service;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import com.example.repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService{
    private ICustomerRepository iCustomerRepository = new CustomerRepository();

    @Override
    public List<Customer> getAll() {
        return iCustomerRepository.getAll();
    }
}
