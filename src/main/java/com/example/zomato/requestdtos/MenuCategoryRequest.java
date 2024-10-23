package com.example.zomato.requestdtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MenuCategoryRequest {

    @NotNull(message = "title can not be null")
    private String title;

}
