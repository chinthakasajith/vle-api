package com.tuto.vle.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tuto.vle.domain.User;
import com.tuto.vle.dto.AuthProvider;
import com.tuto.vle.dto.SignUpRequest;
import com.tuto.vle.dto.WebServiceLoginRequest;
import com.tuto.vle.dto.WebServiceLoginResponse;
import com.tuto.vle.dto.WebServiceRegisterResponse;
import com.tuto.vle.exception.ResourceNotFoundException;
import com.tuto.vle.service.CustomAuthService;
import com.tuto.vle.service.FacebookService;
import com.tuto.vle.service.GoogleService;
import com.tuto.vle.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private UserService userService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  GoogleService googleService;

  @Autowired
  FacebookService facebookService;

  @Autowired
  CustomAuthService customAuthService;

  @PostMapping("/login")
  public WebServiceLoginResponse authenticateUser(
      @RequestBody WebServiceLoginRequest webServiceLoginRequest) throws ResourceNotFoundException {

    if (!AuthProvider.custom.toString().equals(webServiceLoginRequest.getSocial_type()))
      throw new ResourceNotFoundException("User is not registered for custom login !!!");

    return userService.authenticateUser(webServiceLoginRequest.getUsername(),
        webServiceLoginRequest.getPassword());
  }

  @PostMapping("/register")
  public WebServiceRegisterResponse registerUser(@RequestBody SignUpRequest signUpRequest)
      throws GeneralSecurityException, IOException {

    userService.isExistUser(signUpRequest.getEmail());

    User user = null;

    if (AuthProvider.google.toString().equals(signUpRequest.getSocial_type())) {
      user = googleService.getVerifiedUser(signUpRequest.getSocial_token());
    } else if (AuthProvider.custom.toString().equals(signUpRequest.getSocial_type())) {
      user = customAuthService.getCustomLoginUser(signUpRequest);

      user.setPassword(passwordEncoder.encode(user.getPassword()));
    } else if (AuthProvider.facebook.toString().equals(signUpRequest.getSocial_type())) {
      user = facebookService.getViewerData(signUpRequest.getSocial_token());
    }

    return userService.persistUser(user);
  }

  @GetMapping("/token")
  public WebServiceRegisterResponse getToken() throws ResourceNotFoundException {

    User user = new User();
    user.setLastName("miditha");
    user.setEmail("miditha@tuto.com");
    user.setPassword("abc@123");
    user.setSocialType("custom");
    return userService.getToken(user);
  }

}
