package com.example.btl.model.dto;

import lombok.Data;
import lombok.Value;

@Data
public class CustomerService {
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private String cccd;
    private String address;
    private String status;
    private String created;
    private int numWater;
    private double volume;
    private Double price;
    private double total;

    public CustomerService(CusView view) {
        this.id = view.getId();
        this.name = view.getName();
        this.email = view.getEmail();
        this.price = view.getPrice();
        this.phoneNumber = view.getPhoneNumber();
        this.cccd = view.getCccd();
        this.address = view.getAddress();

        this.status = view.getStatus();
        this.created = view.getCreated();
        this.numWater = view.getNumWater();
        this.volume = view.getVolume();
        this.total = view.getVolume()* view.getPrice();
    }
}
