package com.tuto.vle.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tuto.vle.domain.User;
import com.tuto.vle.dto.AuthProvider;
import com.tuto.vle.dto.SignUpRequest;
import com.tuto.vle.dto.WebServiceRegisterResponse;
import com.tuto.vle.service.CustomAuthService;
import com.tuto.vle.service.FacebookService;
import com.tuto.vle.service.GoogleService;
import com.tuto.vle.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

  // @Autowired
  // private AuthenticationManager authenticationManager;

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

  // @Autowired
  // private TokenProvider tokenProvider;

  // @PostMapping("/login")
  // public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
  //
  // Authentication authentication =
  // authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
  // loginRequest.getEmail(), loginRequest.getPassword()));
  //
  // SecurityContextHolder.getContext().setAuthentication(authentication);
  //
  // String token = tokenProvider.createToken(authentication);
  // return ResponseEntity.ok(new AuthResponse(token));
  // }

  @PostMapping("/signup")
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

}
