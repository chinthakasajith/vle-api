package com.tuto.vle.util;

import org.springframework.http.HttpStatus;

public enum CustomErrorCodes {
  FAIL_USER_REGISTRATION(1000, "Could not register user", HttpStatus.BAD_REQUEST), USER_EXISTS(1001,
      " User already exists", HttpStatus.BAD_REQUEST), INVALID_PASSWORD(1002, "Invalid Password",
          HttpStatus.BAD_REQUEST), INVALID_USERNAME(1003, "Invalid email / username",
              HttpStatus.BAD_REQUEST), UNIVERSITY_NOT_FOUND(1004, "University not found",
                  HttpStatus.NOT_FOUND), COURSE_NOT_FOUND(1005, "Course not found",
                      HttpStatus.NOT_FOUND), MODULE_NOT_FOUND(1006, "Module not found",
                          HttpStatus.NOT_FOUND), LESSON_NOT_FOUND(1007, "Lesson not found",
                              HttpStatus.NOT_FOUND);

  private final int id;
  private final String msg;
  private final HttpStatus httpCode;

  CustomErrorCodes(int id, String msg, HttpStatus httpCode) {
    this.id = id;
    this.msg = msg;
    this.httpCode = httpCode;
  }

  public int getId() {
    return this.id;
  }

  public String getMsg() {
    return this.msg;
  }

  public HttpStatus getHttpCode() {
    return this.httpCode;
  }

}
