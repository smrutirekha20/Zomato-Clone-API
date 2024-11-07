package com.example.zomato.utility;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AppResponseBuilder {

    public <T> ResponseEntity<ErrorStructure<T>> error(HttpStatus status, String message, T rootCause) {
        return ResponseEntity
                .status(status)
                .body(ErrorStructure.create(status, message, rootCause));
    }

    public <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, String message, T rootCause) {
        return ResponseEntity
                .status(status)
                .body(ResponseStructure.create(status, message, rootCause));
    }
    public <T> ResponseEntity<ResponseStructure<T>> success(HttpHeaders headers,HttpStatus status,String message,T rootCause){
        return ResponseEntity
                .status(status)
                .headers(headers)
                .body(ResponseStructure.create(status, message, rootCause));
    }

    public ResponseEntity<SimpleResponseStructure> success(HttpStatus status,String message,HttpHeaders headers){
        return  ResponseEntity.status(status)
                .headers(headers)
                .body(SimpleResponseStructure.create(status,message));
    }
}
