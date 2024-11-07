package com.example.zomato.exceptionhandler;


import com.example.zomato.exception.CuisineNotFoundByIdException;
import com.example.zomato.utility.AppResponseBuilder;
import com.example.zomato.utility.ErrorStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class CuisineExceptionHandler {

    private final AppResponseBuilder appResponseBuilder;
    @ExceptionHandler(CuisineNotFoundByIdException.class)
    public ResponseEntity<ErrorStructure<String>> handleCuisineNotFoundById(CuisineNotFoundByIdException ex) {
        return appResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Cuisine not found by given id");
    }
}
