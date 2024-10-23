package com.example.zomato.exceptionhandler;

import com.example.zomato.exception.RestaurantNotFoundByIdException;
import com.example.zomato.utility.AppResponseBuilder;
import com.example.zomato.utility.ErrorStructure;
import com.example.zomato.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class RestaurantExceptionHandler {
    private AppResponseBuilder appResponseBuilder;

    @ExceptionHandler(RestaurantNotFoundByIdException.class)
    public ResponseEntity<ErrorStructure<String>> handleRestaurantNotFoundById(RestaurantNotFoundByIdException ex) {
        return appResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Restaurant not found by given id");
    }
}
