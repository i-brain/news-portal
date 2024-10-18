package com.ibrain.news.admin.panel.exception;

import com.ibrain.news.admin.panel.response.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseWrapper<Void>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(new ResponseWrapper<>(false, ex.getMessage(), null), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseWrapper<Void>> handleGenericException(Exception ex) {
        return new ResponseEntity<>(new ResponseWrapper<>(false, "An unexpected error occurred", null), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
