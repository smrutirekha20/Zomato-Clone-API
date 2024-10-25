package com.example.zomato.entity;

import com.example.zomato.config.GenerateCustomId;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name= "address")
@Data
public class Address {

    @Id
    @GenerateCustomId
    @Column(name = "address_id")
    private String addressId;

    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "land_mark")
    private String landMark;

    @Column(name = "area")
    private String area;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "pin_code")
    private String pinCode;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
