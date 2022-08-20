package com.example.ExceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    private final static String NOT_FOUND="404";
    private final static  String BAD_REQUEST="400";
    private final static  String NOT_ACCEPTABLE="406";
    private final static  String NULL_POINT_EXCEPTION="500"; 
    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<ErrorDetails> ResourceNotFoundException(CustomerException ex, WebRequest webRequest){
        ErrorDetails errorDetails =new ErrorDetails(new Date(),
                ex.getMessage(),NOT_FOUND,webRequest.getDescription(false));
        
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> globalException(Exception ex, WebRequest webRequest){
        ErrorDetails errorDetails =new ErrorDetails(new Date(),
                ex.getMessage(),BAD_REQUEST,webRequest.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SignUpException.class)
    public ResponseEntity<ErrorDetails> validationException(SignUpException ex, WebRequest webRequest){
        ErrorDetails errorDetails =new ErrorDetails(new Date(),
                ex.getMessage(),NOT_ACCEPTABLE,webRequest.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_ACCEPTABLE);
    }

}