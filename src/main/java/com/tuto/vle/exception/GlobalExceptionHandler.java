package com.tuto.vle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import com.tuto.vle.dto.AuthErrorDto;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> resourceNotFoundException(Exception ex, WebRequest request) {
    // ErrorDetails errorDetails =
    // new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
    // ErrorDetails errorDetails =
    // new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(UserExistsException.class)
  public ResponseEntity<?> userExistsExceptionHandler(Exception ex, WebRequest request) {

    AuthErrorDto authErrorDto = new AuthErrorDto(1001, "User already exists");
    return new ResponseEntity<>(authErrorDto, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(UserRegisterException.class)
  public ResponseEntity<?> userRegisterExceptionHandler(Exception ex, WebRequest request) {
    AuthErrorDto authErrorDto = new AuthErrorDto(1000, "Could not register user");
    return new ResponseEntity<>(authErrorDto, HttpStatus.BAD_REQUEST);
  }

}

