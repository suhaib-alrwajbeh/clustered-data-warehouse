package com.fxdeals.ClusteredDataWarehouse.handler;

import com.fxdeals.ClusteredDataWarehouse.dto.ErrorResponseDto;
import jakarta.validation.ValidationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(Exception ex){
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
            .error("Bad Request")
            .message(ex.getMessage())
            .statusCode(HttpStatus.BAD_REQUEST)
            .timestamp(ZonedDateTime.now())
            .build();

        return ResponseEntity
            .badRequest()
            .body(errorResponseDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleValidation(MethodArgumentNotValidException ex){
        String message = ex.getBindingResult().getAllErrors().stream()
            .findFirst()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .orElse(null);

        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
            .error("Validation Exception")
            .message(message)
            .statusCode(HttpStatus.BAD_REQUEST)
            .timestamp(ZonedDateTime.now())
            .build();

        return ResponseEntity
            .badRequest()
            .body(errorResponseDto);
    }
}
