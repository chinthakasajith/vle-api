package com.tuto.vle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

  private static final long serialVersionUID = 1L;

  public ResourceNotFoundException(String message) {
    // message - empty string array not passed to super class as per the requrement
    // Ref :
    // https://docs.google.com/document/d/1D204YBadBZ9ykDI-WVzrfSRyYKZlH8ed3FToHh76ebs/edit?fbclid=IwAR3UIqAfp8W7cqqUajgHa7V289Tz2A3YdAy9O-gmAFpj70BR_p7psGwMUMs#

    super();
  }
}
