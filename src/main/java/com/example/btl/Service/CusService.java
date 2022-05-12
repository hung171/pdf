package com.example.btl.Service;

import com.example.btl.model.entities.Customer;

import java.util.List;

public interface CusService  {
    List<Customer> findByStatus(int status);

}
