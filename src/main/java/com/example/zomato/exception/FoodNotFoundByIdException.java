package com.example.zomato.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FoodNotFoundByIdException extends RuntimeException {

    private final String message;
}
