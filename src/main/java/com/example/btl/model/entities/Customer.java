package com.example.btl.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    private String email;
    @Column(name = "phone_num")
    private String phoneNumber;
    private String cccd;
    private String address;
    @Column(name = "status_using")
    private String status;
    private String created;
}
