package com.motta.exception;

import com.motta.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URISyntaxException;

@RestControllerAdvice
public class ExceptionGlobalHandler {

    @ExceptionHandler(OriginalUrlNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleOriginalUrlNotFoundException(OriginalUrlNotFoundException ex) {
        return ResponseEntity.status(404).body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(URISyntaxException.class)
    public ResponseEntity<ErrorResponse> handleURISyntaxException(URISyntaxException ex) {
        return ResponseEntity.status(500).body(new ErrorResponse(ex.getMessage()));
    }

}
