package com.example.ExceptionHandlers;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String status;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String path;
}