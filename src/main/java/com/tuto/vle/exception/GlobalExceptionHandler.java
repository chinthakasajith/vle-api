package com.tuto.vle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import com.tuto.vle.dto.AuthErrorDto;
import com.tuto.vle.util.CustomErrorCodes;

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

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<?> customExceptionHandler(CustomException customException) {
    CustomErrorCodes customErrorCodes = customException.getCustomErrorCodes();
    AuthErrorDto authErrorDto =
        new AuthErrorDto(customErrorCodes.getId(), customErrorCodes.getMsg());
    return new ResponseEntity<>(authErrorDto, customErrorCodes.getHttpCode());
  }

}

