package com.example.ExceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class SignUpException extends RuntimeException {
    
    private String fieldName1;
    private String fieldName2;
    private String fieldValue1;
    private String fieldValue2;
    
    private final  static String errorMessage=    
                                             "%s= '%s'  or/and  %s= '%s'  doesn't fulfill criteria. Email must be valid. Password must be atleast 8 characters long ";

    public String getFieldName1() {
        return fieldName1;
    }

    public String getFieldName2() {
        return fieldName2;
    }

    public String getFieldValue1() {
        return fieldValue1;
    }

    public String getFieldValue2() {
        return fieldValue2;
    }

    public SignUpException(String fieldName1,String fieldValue1 ,String fieldName2,String fieldValue2) {
        super(String.format(errorMessage,fieldName1,fieldValue1,fieldName2,fieldValue2));
        this.fieldName1 = fieldName1;
        this.fieldValue1=fieldValue1;
        this.fieldName2 = fieldName2;
        this.fieldValue2=fieldValue2;
    }
}