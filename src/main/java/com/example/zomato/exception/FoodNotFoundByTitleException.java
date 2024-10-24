package com.example.zomato.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FoodNotFoundByTitleException extends RuntimeException {

    private final String message;
}
