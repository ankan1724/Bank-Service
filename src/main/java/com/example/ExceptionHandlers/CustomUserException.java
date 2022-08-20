package com.example.ExceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomUserException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private String  fieldValue;
    private final  static String errorMessage=      "%s with %s : '%s' doesn't exists, please signUp or check email or password again";

    public CustomUserException(String resourceName, String fieldName, String  fieldValue) {
        super(String.format( errorMessage,resourceName, fieldName, fieldValue)); 
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }
}