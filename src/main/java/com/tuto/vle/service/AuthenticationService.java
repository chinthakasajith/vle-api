package com.tuto.vle.service;

import com.tuto.vle.domain.User;
import com.tuto.vle.dto.SignUpRequest;

public interface AuthenticationService {
  User getViewerUserData(SignUpRequest signUpRequest) throws Exception;
}
