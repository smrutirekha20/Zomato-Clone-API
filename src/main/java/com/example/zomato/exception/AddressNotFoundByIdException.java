package com.example.zomato.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddressNotFoundByIdException extends RuntimeException {

    private final String message;
}
