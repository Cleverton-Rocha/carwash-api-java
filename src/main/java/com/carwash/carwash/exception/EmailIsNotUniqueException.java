package com.carwash.carwash.exception;

public class EmailIsNotUniqueException extends RuntimeException {
  public EmailIsNotUniqueException(String message) {
    super(message);
  }
}
