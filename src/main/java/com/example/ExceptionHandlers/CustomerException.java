package com.example.ExceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Long  fieldValue;
    private final  static String errorMessage=    "%s with %s : '%s' doesn't exists";

    public CustomerException(String resourceName, String fieldName, Long  fieldValue) {
        super(String.format(errorMessage, resourceName, fieldName, fieldValue));
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

    public Long  getFieldValue() {
        return fieldValue;
    }
}