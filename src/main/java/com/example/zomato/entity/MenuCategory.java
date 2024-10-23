package com.example.zomato.entity;

import com.example.zomato.config.GenerateCustomId;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "menu_categories")
@Data
public class MenuCategory {

    @Id
    @GenerateCustomId
    @Column(name = "menu_category_id")
    private String menuCategoryId;

    @Column(name = "title")
    private String title;

    @ManyToOne
    private Restaurant restaurant;
}
