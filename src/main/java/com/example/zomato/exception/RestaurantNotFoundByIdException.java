package com.example.zomato.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RestaurantNotFoundByIdException extends RuntimeException{

    private final String message;
}
