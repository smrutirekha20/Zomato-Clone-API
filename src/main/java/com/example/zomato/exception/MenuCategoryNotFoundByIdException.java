package com.example.zomato.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MenuCategoryNotFoundByIdException extends RuntimeException{

    private final String message;
}
