package com.assessment.airport.dto;

import lombok.Data;

@Data
public class ExceptionDto {

    private String userMessage;

    public ExceptionDto(String message) {
        this.userMessage = message;
    }
}
