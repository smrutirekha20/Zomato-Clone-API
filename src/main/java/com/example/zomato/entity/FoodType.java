package com.example.zomato.entity;

import com.example.zomato.config.GenerateCustomId;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "food_type")
public class FoodType {

    @Id
    @GenerateCustomId
    @Column(name = "type_id")
    private String typeId;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "foodType",cascade = CascadeType.ALL)
    private List< Food> food;
}
