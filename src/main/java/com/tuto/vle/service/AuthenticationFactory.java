package com.tuto.vle.service;

public class AuthenticationFactory {
  public AuthenticationService getAuthService(String socialType) {
    if (socialType == null) {
      return null;
    }
    if (socialType.equalsIgnoreCase("google")) {
      return new GoogleService();

    } else if (socialType.equalsIgnoreCase("facebook")) {
      return new FacebookService();

    } else if (socialType.equalsIgnoreCase("custom")) {
      return new CustomAuthService();
    }

    return null;
  }
}
