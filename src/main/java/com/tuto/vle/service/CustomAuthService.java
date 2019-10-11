package com.tuto.vle.service;

import org.springframework.stereotype.Service;
import com.tuto.vle.domain.User;
import com.tuto.vle.dto.SignUpRequest;

@Service
public class CustomAuthService {

  public User getCustomLoginUser(SignUpRequest signUpRequest) {
    User user = new User();
    user.setLastName(signUpRequest.getName());
    user.setEmail(signUpRequest.getEmail());
    user.setPassword(signUpRequest.getPassword());
    user.setSocialType(signUpRequest.getSocial_type());
    return user;
  }

}
