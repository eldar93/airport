package com.assessment.airport.exception;

import com.assessment.airport.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private static final String TYPE_MISMATCH_MESSAGE_PATTERN = "Incorrect value of request parameter: %s";

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    ResponseEntity<ExceptionDto> methodArgumentTypeMismatchHandler(MethodArgumentTypeMismatchException ex) {
        ExceptionDto dto = new ExceptionDto(
                String.format(TYPE_MISMATCH_MESSAGE_PATTERN, ex.getName() +"=" +ex.getValue()));
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

}
