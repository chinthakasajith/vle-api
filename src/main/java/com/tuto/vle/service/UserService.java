package com.tuto.vle.service;

import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tuto.vle.domain.User;
import com.tuto.vle.dto.WebServiceRegisterResponse;
import com.tuto.vle.exception.BadRequestException;
import com.tuto.vle.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public WebServiceRegisterResponse persistUser(User user) {

    Timestamp current = new Timestamp(System.currentTimeMillis());
    user.setCreatedAt(current);
    user.setUpdatedAt(current);
    user.setLastLogin(current);
    User result = userRepository.save(user);

    WebServiceRegisterResponse webServiceRegisterResponse = new WebServiceRegisterResponse();
    webServiceRegisterResponse.setName(result.getLastName());

    return webServiceRegisterResponse;
  }

  public void isExistUser(String signUpRequest) {
    if (userRepository.existsByEmail(signUpRequest)) {
      throw new BadRequestException("Email already in use.");
    }
  }

}
