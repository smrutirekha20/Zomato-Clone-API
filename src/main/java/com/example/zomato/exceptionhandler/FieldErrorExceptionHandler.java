package com.example.zomato.exceptionhandler;

import com.example.zomato.utility.ErrorStructure;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status,
                                                                  WebRequest request) {
        List<ErrorBody> errors = ex.getAllErrors().stream().map(error -> {
            FieldError err = (FieldError) error;

            return new ErrorBody(
                    err.getField(),
                    err.getDefaultMessage(),
                    err.getRejectedValue()
            );
        }).toList();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorStructure.create(HttpStatus.BAD_REQUEST, "invalid input", errors));
    }

    @Data
    private static class ErrorBody {
        private final String fieldName;
        private final String message;
        private final Object rejectedValue;

        public ErrorBody(String fieldName, String message, Object rejectedValue) {
            this.fieldName = fieldName;
            this.message = message;
            this.rejectedValue = rejectedValue;

        }
    }
}
