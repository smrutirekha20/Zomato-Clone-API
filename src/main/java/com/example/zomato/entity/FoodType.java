package com.example.zomato.entity;

import com.example.zomato.config.GenerateCustomId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

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
}
