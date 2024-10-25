package com.example.zomato.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends User{
}
