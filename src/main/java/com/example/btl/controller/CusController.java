package com.example.btl.controller;

import com.example.btl.Service.CusService;
import com.example.btl.model.dto.CusView;
import com.example.btl.model.entities.Customer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CusController {

    private final CusService cusService;

    public CusController(CusService cusService) {
        this.cusService = cusService;
    }

    @PostMapping("/search")
    public List<Customer> search(@RequestBody int status) {
        return cusService.findByStatus(status);
    }

}
