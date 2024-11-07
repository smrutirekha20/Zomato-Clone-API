package com.example.zomato.utility;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorStructure<T> {
    private int status;
    private String message;
    private T rootCause;

    public static <T> ErrorStructure<T> create(HttpStatus status, String message, T rootCause) {
        ErrorStructure<T> structure = new ErrorStructure<T>();
        structure.setStatus(status.value());
        structure.setMessage(message);
        structure.setRootCause(rootCause);

        return structure;
    }
}
