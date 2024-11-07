package com.example.zomato.entity;

import com.example.zomato.config.GenerateCustomId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Image {

    @Id
    @GenerateCustomId
    @Column(name = "image_id")
    private String imageId;

    @Column(name= "image_url")
    private String imageURL;
}
