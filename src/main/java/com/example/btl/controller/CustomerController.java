package com.example.btl.controller;

import com.example.btl.Service.CusService;
import com.example.btl.model.dto.CusView;
import com.example.btl.model.dto.CustomerService;
import com.example.btl.model.entities.Customer;
import com.example.btl.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/customer/all")
    public String getAll(Model model) {
        List<Customer> list = customerRepository.findAll();
        model.addAttribute("items", list);
        return "/customer/customer";
    }

    @RequestMapping("/customer/home")
    public String home() {
        return "/admin/index";
    }

    @RequestMapping("/customer/setting")
    public String setting() {
        return "/admin/setting";
    }

    @RequestMapping("/customer")
    public String getInfo(Model model, @RequestParam(value = "id") int id) {
        CusView customer = customerRepository.findCustomerServiceI(id);
        CustomerService customerService = new CustomerService(customer);
        model.addAttribute("item", customerService);
        model.addAttribute("id", id);
        return "/customer/info";
    }

}
