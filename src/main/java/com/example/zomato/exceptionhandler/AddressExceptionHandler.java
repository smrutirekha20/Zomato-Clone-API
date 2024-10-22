package com.example.zomato.exceptionhandler;


import com.example.zomato.exception.AddressNotFoundByIdException;
import com.example.zomato.utility.AppResponseBuilder;
import com.example.zomato.utility.ErrorStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class AddressExceptionHandler {

    private AppResponseBuilder appResponseBuilder;

    @ExceptionHandler(AddressNotFoundByIdException.class)
    public ResponseEntity<ErrorStructure<String>> handleAddressNotFoundById(AddressNotFoundByIdException ex) {
        return appResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Address not found by given id");
    }
}
