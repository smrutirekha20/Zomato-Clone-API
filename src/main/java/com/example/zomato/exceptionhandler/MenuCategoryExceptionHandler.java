package com.example.zomato.exceptionhandler;

import com.example.zomato.exception.MenuCategoryNotFoundByIdException;
import com.example.zomato.exception.RestaurantNotFoundByIdException;
import com.example.zomato.utility.AppResponseBuilder;
import com.example.zomato.utility.ErrorStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class MenuCategoryExceptionHandler {

    private final AppResponseBuilder appResponseBuilder;

    @ExceptionHandler(MenuCategoryNotFoundByIdException.class)
    public ResponseEntity<ErrorStructure<String>> handleMenuCategoryNotFoundById(MenuCategoryNotFoundByIdException ex) {
        return appResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "MenuCategory not found by given id");
    }
}
