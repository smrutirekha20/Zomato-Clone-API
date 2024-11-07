package com.example.zomato.requestdtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ImageRequest {

    @NotNull(message = "image url can not be null")
    @NotBlank(message = "image url can not be blank")
    private String imageURL;
}
