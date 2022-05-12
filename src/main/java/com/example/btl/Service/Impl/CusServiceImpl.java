package com.example.btl.Service.Impl;

import com.example.btl.Service.CusService;
import com.example.btl.model.entities.Customer;
import com.example.btl.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CusServiceImpl implements CusService {
    private final CustomerRepository repository;

    public CusServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> findByStatus(int status) {
        List<Customer> listCustomer = repository.findByStatus(status);
        return listCustomer;
    }
}
