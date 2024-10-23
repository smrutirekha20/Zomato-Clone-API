package com.example.zomato.entity;

import com.example.zomato.config.GenerateCustomId;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "cuisines")
@Data
public class Cuisine {

    @Id
    @GenerateCustomId
    @Column(name = "cuisine_id")
    private String cuisineId;

    @Column(name= "title")
    private String title;

    @ManyToMany(mappedBy = "cuisines",cascade = CascadeType.ALL)
    private List<Restaurant> restaurants;
}
