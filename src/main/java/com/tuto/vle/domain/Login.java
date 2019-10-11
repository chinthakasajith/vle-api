package com.tuto.vle.domain;

public class Login {
  private int user_id;
  private String public_user_id;
  private String email;
  private String password;
  private String first_name;
  private String last_name;
  private Boolean is_verified;
  private Boolean is_active;
  private String avatar;
  private String social_type;
  private String token_hash;

  public Login(int user_id, String public_user_id, String email, String password, String first_name,
      String last_name, Boolean is_verified, Boolean is_active, String avatar, String social_type,
      String token_hash) {
    super();
    this.user_id = user_id;
    this.public_user_id = public_user_id;
    this.email = email;
    this.password = password;
    this.first_name = first_name;
    this.last_name = last_name;
    this.is_verified = is_verified;
    this.is_active = is_active;
    this.avatar = avatar;
    this.social_type = social_type;
    this.token_hash = token_hash;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public String getPublic_user_id() {
    return public_user_id;
  }

  public void setPublic_user_id(String public_user_id) {
    this.public_user_id = public_user_id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public Boolean getIs_verified() {
    return is_verified;
  }

  public void setIs_verified(Boolean is_verified) {
    this.is_verified = is_verified;
  }

  public Boolean getIs_active() {
    return is_active;
  }

  public void setIs_active(Boolean is_active) {
    this.is_active = is_active;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getSocial_type() {
    return social_type;
  }

  public void setSocial_type(String social_type) {
    this.social_type = social_type;
  }

  public String getToken_hash() {
    return token_hash;
  }

  public void setToken_hash(String token_hash) {
    this.token_hash = token_hash;
  }
}
