package com.example.zomato.utility;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResponseStructure<T> {
    private int status;
    private String message;
    private T data;

    public static <T> ResponseStructure<T> create(HttpStatus status, String message, T data) {
        ResponseStructure<T> structure = new ResponseStructure<>();
        structure.setStatus(status.value());
        structure.setData(data);
        structure.setMessage(message);

        return structure;
    }
}
