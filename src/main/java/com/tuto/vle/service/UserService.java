package com.tuto.vle.service;

import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.tuto.vle.domain.Login;
import com.tuto.vle.domain.Token;
import com.tuto.vle.domain.User;
import com.tuto.vle.domain.UserTokens;
import com.tuto.vle.dto.WebServiceLoginResponse;
import com.tuto.vle.dto.WebServiceRegisterResponse;
import com.tuto.vle.exception.BadRequestException;
import com.tuto.vle.exception.ResourceNotFoundException;
import com.tuto.vle.repositories.UserRepository;
import com.tuto.vle.repositories.UserTokensRepository;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  TokenService tokenService;

  @Autowired
  UserTokensRepository userTokensRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public WebServiceRegisterResponse persistUser(User user) {

    Timestamp current = new Timestamp(System.currentTimeMillis());
    user.setCreatedAt(current);
    user.setUpdatedAt(current);
    user.setLastLogin(current);
    user.setIsActive(true);
    User result = userRepository.save(user);

    Token token = tokenService.generateToken();

    UserTokens userTokens = new UserTokens();
    userTokens.setTokenId(token.getTokenId());
    userTokens.setUserId(result.getUserId());
    UserTokens activeUserToken = userTokensRepository.save(userTokens);

    WebServiceRegisterResponse webServiceRegisterResponse = new WebServiceRegisterResponse();
    webServiceRegisterResponse.setUserId(result.getUserId());
    webServiceRegisterResponse.setName(result.getLastName());
    webServiceRegisterResponse.setAccess_token(token.getTokenHash());

    return webServiceRegisterResponse;
  }

  public void isExistUser(String signUpRequest) {
    if (userRepository.existsByEmail(signUpRequest)) {
      throw new BadRequestException("Email already in use.");
    }
  }

  public WebServiceLoginResponse authenticateUser(String email, String password)
      throws ResourceNotFoundException {

    Login user = userRepository.authenticateUser(email);

    if (user == null)
      throw new ResourceNotFoundException("No user registered to this user id : " + email);

    if (passwordEncoder.matches(password, user.getPassword())) {
      WebServiceLoginResponse webServiceLoginResponse = new WebServiceLoginResponse();
      webServiceLoginResponse.setUserId(user.getUser_id());
      webServiceLoginResponse.setUsername(user.getEmail());
      webServiceLoginResponse.setSocialType(user.getSocial_type());
      webServiceLoginResponse.setAccess_token(user.getToken_hash());
      return webServiceLoginResponse;
    }

    return new WebServiceLoginResponse();

  }

  public WebServiceRegisterResponse getToken(User user) {

    Timestamp current = new Timestamp(System.currentTimeMillis());
    user.setCreatedAt(current);
    user.setUpdatedAt(current);
    user.setLastLogin(current);
    user.setIsActive(true);

    Token token = tokenService.generateToken();

    UserTokens userTokens = new UserTokens();
    userTokens.setTokenId(token.getTokenId());
    userTokens.setUserId(user.getUserId());
    UserTokens activeUserToken = userTokensRepository.save(userTokens);

    WebServiceRegisterResponse webServiceRegisterResponse = new WebServiceRegisterResponse();
    webServiceRegisterResponse.setUserId(user.getUserId());
    webServiceRegisterResponse.setName(user.getLastName());
    webServiceRegisterResponse.setAccess_token(token.getTokenHash());

    return webServiceRegisterResponse;
  }

}
