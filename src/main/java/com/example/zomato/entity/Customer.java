package com.example.zomato.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "customer")
public class Customer extends User{

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Address> addresses;
}
