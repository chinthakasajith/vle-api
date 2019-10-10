package com.tuto.vle.dto;

public class SignUpRequest {

  private String social_type;// - custom / google / facebook
  private String social_token; // - google / facebook token
  private String email;
  private String password;
  private String social_userid; // - google / facebook user ID
  private String mobile_number;
  private String name;
  private String date_of_birth;
  private String gender;
  private String language;
  private String country;
  private boolean whitelisted;
  private String device_id;

  public String getSocial_type() {
    return social_type;
  }

  public void setSocial_type(String social_type) {
    this.social_type = social_type;
  }

  public String getSocial_token() {
    return social_token;
  }

  public void setSocial_token(String social_token) {
    this.social_token = social_token;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSocial_userid() {
    return social_userid;
  }

  public void setSocial_userid(String social_userid) {
    this.social_userid = social_userid;
  }

  public String getMobile_number() {
    return mobile_number;
  }

  public void setMobile_number(String mobile_number) {
    this.mobile_number = mobile_number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDate_of_birth() {
    return date_of_birth;
  }

  public void setDate_of_birth(String date_of_birth) {
    this.date_of_birth = date_of_birth;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public boolean isWhitelisted() {
    return whitelisted;
  }

  public void setWhitelisted(boolean whitelisted) {
    this.whitelisted = whitelisted;
  }

  public String getDevice_id() {
    return device_id;
  }

  public void setDevice_id(String device_id) {
    this.device_id = device_id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
