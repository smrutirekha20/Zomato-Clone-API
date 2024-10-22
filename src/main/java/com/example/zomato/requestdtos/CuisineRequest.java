package com.example.zomato.requestdtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CuisineRequest {

    @NotNull(message = "title can not be null")
    @NotBlank(message = "title can not be blank")
    private String title;

}
