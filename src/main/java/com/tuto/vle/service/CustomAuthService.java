package com.tuto.vle.service;

import org.springframework.stereotype.Service;
import com.tuto.vle.domain.User;
import com.tuto.vle.dto.SignUpRequest;

@Service
public class CustomAuthService implements AuthenticationService {

  public User getViewerUserData(SignUpRequest signUpRequest) throws Exception {
    User user = new User();
    user.setLastName(signUpRequest.getName());
    user.setEmail(signUpRequest.getEmail());
    user.setPassword(signUpRequest.getPassword());
    user.setSocialType(signUpRequest.getSocial_type());
    return user;
  }

}
