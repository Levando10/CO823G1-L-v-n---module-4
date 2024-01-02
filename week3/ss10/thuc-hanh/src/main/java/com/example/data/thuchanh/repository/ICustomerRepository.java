package com.example.data.thuchanh.repository;

import com.example.data.thuchanh.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    void deleteCustomerById(Long id);
}
