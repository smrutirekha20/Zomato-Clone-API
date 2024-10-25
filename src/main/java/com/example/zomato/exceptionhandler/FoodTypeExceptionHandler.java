package com.example.zomato.exceptionhandler;

import com.example.zomato.exception.FoodNotFoundByTitleException;
import com.example.zomato.utility.AppResponseBuilder;
import com.example.zomato.utility.ErrorStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class FoodExceptionHandler {

    private final AppResponseBuilder appResponseBuilder;

    @ExceptionHandler(FoodNotFoundByTitleException.class)
    public ResponseEntity<ErrorStructure<String>> handleFoodNotFoundByTitle(FoodNotFoundByTitleException ex) {
        return appResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Food not found by given title");
    }
}
