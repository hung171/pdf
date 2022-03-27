package com.example.btl.controller;

import com.example.btl.model.CustomerModel;
import com.example.btl.model.entities.Customer;
import com.example.btl.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerModel customerModel;

    @RequestMapping("/customer/all")
    public String getAll(Model model) {
        List<Customer> list = customerRepository.findAll();
        model.addAttribute("items",list);
        return "/customer/customer";
    }

    @RequestMapping("/customer")
    public String index() {
        return "/admin/index";
    }

    @RequestMapping("/customer/exportAll")
    public String exportAll() {

        return "/admin/index";
    }
}
