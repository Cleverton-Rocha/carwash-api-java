package com.carwash.carwash.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(EmailIsNotUniqueException.class)
  public ResponseEntity<String> handleEmailIsNotUnique(EmailIsNotUniqueException ex) {
    return ResponseEntity.status(400).body(ex.getMessage());
  }

  @ExceptionHandler(CustomerNotFoundException.class)
  public ResponseEntity<String> handleCustomerNotFound(CustomerNotFoundException ex) {
    return ResponseEntity.status(404).body(ex.getMessage());
  }
}
