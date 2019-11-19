package com.tuto.vle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.tuto.vle.domain.User;
import com.tuto.vle.dto.SignUpRequest;

@Service
public class CustomAuthService implements AuthenticationService {

  @Autowired
  PasswordEncoder passwordEncoder;

  public User getViewerUserData(SignUpRequest signUpRequest) throws Exception {

    User user = new User();
    user.setLastName(signUpRequest.getName());
    user.setEmail(signUpRequest.getEmail());
    user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
    user.setSocialType(signUpRequest.getSocial_type());
    return user;
  }

}
