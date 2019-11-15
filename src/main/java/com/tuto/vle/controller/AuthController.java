package com.tuto.vle.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/auth")
@Api(value = "Auth Controller", description = "Used for user authentication")
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
  @ApiOperation(value = "Login endpoint", response = WebServiceLoginResponse.class)
  public WebServiceLoginResponse authenticateUser(
      @RequestBody WebServiceLoginRequest webServiceLoginRequest) throws Exception {

    if (!AuthProvider.custom.toString().equals(webServiceLoginRequest.getSocial_type()))
      throw new ResourceNotFoundException("User is not registered for custom login !!!");

    return userService.authenticateUser(webServiceLoginRequest.getUsername(),
        webServiceLoginRequest.getPassword());
  }

  @PostMapping("/register")
  @ApiOperation(value = "Register endpoint", response = WebServiceRegisterResponse.class)
  public WebServiceRegisterResponse registerUser(@RequestBody SignUpRequest signUpRequest)
      throws GeneralSecurityException, IOException, Exception {

    User user = null;

    if (AuthProvider.google.toString().equals(signUpRequest.getSocial_type())) {
      user = googleService.getVerifiedUser(signUpRequest.getSocial_token());
    } else if (AuthProvider.custom.toString().equals(signUpRequest.getSocial_type())) {
      user = customAuthService.getCustomLoginUser(signUpRequest);

      user.setPassword(passwordEncoder.encode(user.getPassword()));
    } else if (AuthProvider.facebook.toString().equals(signUpRequest.getSocial_type())) {
      user = facebookService.getViewerData(signUpRequest.getSocial_token());
    }

    userService.isExistUser(user.getEmail());

    return userService.persistUser(user);
  }

  @GetMapping("/token")
  @ApiOperation(value = "Token endpoint", response = WebServiceRegisterResponse.class)
  @ApiImplicitParams({
      @ApiImplicitParam(name = "Content-Type", value = "application/json", paramType = "header"),
      @ApiImplicitParam(name = "bearer-access-token", value = "Generated access token",
          paramType = "header")})
  public WebServiceRegisterResponse getToken(
      @ApiIgnore @RequestAttribute("bearer-access-token") String accessToken,
      @ApiIgnore @RequestAttribute("mobile-user-id") Integer mobileUserId,
      @ApiIgnore @RequestAttribute("token-id") Integer tokenId) throws ResourceNotFoundException {
    return userService.getToken(mobileUserId, accessToken, tokenId);
  }

}
