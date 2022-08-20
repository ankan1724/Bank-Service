package com.example.ExceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class NullPointerException extends MissingServletRequestParameterException {
    private String parameterName;
    private String parameterType;
    private boolean missingAfterConversion;
   // private final  static String errorMessage=      "%s of type %s cannot be empty.";
    public NullPointerException(String parameterName, String parameterType, boolean missingAfterConversion) {
        super(parameterName, parameterType, missingAfterConversion);
        this.parameterName=parameterName;
        this.parameterType=parameterType;
        this.missingAfterConversion=missingAfterConversion;
    }

    @Override
    public String getMessage() {
        return  this.parameterName+" cannot be empty/null";
    }
}