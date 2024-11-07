package com.example.zomato.utility;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class SimpleResponseStructure {
    private int status;
    private String message;

    public static SimpleResponseStructure create(HttpStatus status,String message){
        SimpleResponseStructure responseStructure=new SimpleResponseStructure();
        responseStructure.setStatus(status.value());
        responseStructure.setMessage(message);
        return responseStructure;
    }
}
