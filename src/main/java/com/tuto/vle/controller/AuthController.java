package com.tuto.vle.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tuto.vle.domain.Student;
import com.tuto.vle.domain.StudentCode;
import com.tuto.vle.domain.User;
import com.tuto.vle.dto.AuthProvider;
import com.tuto.vle.dto.RegisterStudentToUniversity;
import com.tuto.vle.dto.SignUpRequest;
import com.tuto.vle.dto.WebServiceLoginRequest;
import com.tuto.vle.dto.WebServiceLoginResponse;
import com.tuto.vle.dto.WebServiceRegisterResponse;
import com.tuto.vle.exception.ResourceNotFoundException;
import com.tuto.vle.service.AuthenticationFactory;
import com.tuto.vle.service.CustomAuthService;
import com.tuto.vle.service.FacebookService;
import com.tuto.vle.service.GoogleService;
import com.tuto.vle.service.StudentService;
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
  GoogleService googleService;

  @Autowired
  FacebookService facebookService;

  @Autowired
  CustomAuthService customAuthService;

  @Autowired
  StudentService studentService;

  // @Autowired
  // PasswordEncoder passwordEncoder;

  @Autowired
  AuthenticationFactory authenticationFactory;

  @PostMapping("/login")
  @ApiOperation(value = "Login endpoint", response = WebServiceLoginResponse.class)
  public WebServiceRegisterResponse authenticateUser(
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

    // if (signUpRequest.getPassword() != null) {
    // signUpRequest.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
    // }

    User user = authenticationFactory.getAuthService(signUpRequest.getSocial_type())
        .getViewerUserData(signUpRequest);

    if (userService.findUserByEmail(user.getEmail()) != null) {
      if ("facebook".equals(signUpRequest.getSocial_type())
          || "google".equals(signUpRequest.getSocial_type())) {
        return userService.authenticateUser(user.getEmail(), null);
      }
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

  @PostMapping("/user/assign/{type}/{resource_id}")
  @ApiOperation(value = "Linking a user [student] to university",
      response = WebServiceRegisterResponse.class)
  public void registerStudentToUniversity(
      @ApiIgnore @RequestAttribute("mobile-user-id") Integer mobileUserId,
      @PathVariable String type, @PathVariable Integer resource_id,
      @RequestBody RegisterStudentToUniversity registerStudentToUniversity)
      throws GeneralSecurityException, IOException, Exception {

    StudentCode studentCode = studentService
        .persistStudentCode(registerStudentToUniversity.getStudent_Id(), mobileUserId);

    if (studentCode != null) {
      Student student = studentService.getStudentByStudentID(studentCode.getAuthCode());
      if ("university".equals(type)) {
        student.setUniversityId(resource_id);
      } else if ("division".equals(type)) {
        student.setDivisionId(resource_id);
      } else if ("course".equals(type)) {
        // no course id filed in the table
      }

    }

  }
}
