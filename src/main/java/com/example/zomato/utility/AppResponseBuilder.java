package com.example.zomato.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AppResponseBuilder {

    public <T> ResponseEntity<ErrorStructure<T>> error(HttpStatus status,String message,T rootCause ){
        return ResponseEntity
                .status(status)
                .body(ErrorStructure.create(status,message, rootCause));
    }
    public <T> ResponseEntity<ErrorStructure<T>> success(HttpStatus status, String message, T rootCause){
        return ResponseEntity
                .status(status)
                .body(ErrorStructure.create(status,message, rootCause));
    }
}
