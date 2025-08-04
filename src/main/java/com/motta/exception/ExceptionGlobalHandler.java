package com.motta.exception;

import com.motta.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(400).body(new ErrorResponse("Invalid request body"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error ->
                errors.put("error", error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

}
