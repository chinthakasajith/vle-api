package com.tuto.vle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFactory {

  @Autowired
  GoogleService googleService;

  @Autowired
  FacebookService facebookService;

  @Autowired
  CustomAuthService customAuthService;

  public AuthenticationService getAuthService(String socialType) {
    if (socialType == null) {
      return null;
    }
    if (socialType.equalsIgnoreCase("google")) {
      return googleService;

    } else if (socialType.equalsIgnoreCase("facebook")) {
      return facebookService;

    } else if (socialType.equalsIgnoreCase("custom")) {
      return customAuthService;
    }

    return null;
  }
}
