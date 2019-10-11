package com.tuto.vle.dto;

public class WebServiceLoginRequest {
  private String username;
  private String password;
  private String social_type; // custom
  private String device_id;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSocial_type() {
    return social_type;
  }

  public void setSocial_type(String social_type) {
    this.social_type = social_type;
  }

  public String getDevice_id() {
    return device_id;
  }

  public void setDevice_id(String device_id) {
    this.device_id = device_id;
  }

}
