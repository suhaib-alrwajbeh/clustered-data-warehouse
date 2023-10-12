package com.fxdeals.ClusteredDataWarehouse.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.time.ZonedDateTime;

@Data
@Builder
public class ErrorResponseDto {

    private String message;
    private String error;
    private ZonedDateTime timestamp;
    private HttpStatus statusCode;
}
