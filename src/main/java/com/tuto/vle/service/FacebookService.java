package com.tuto.vle.service;

import org.springframework.stereotype.Service;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.User;

@Service
public class FacebookService {

  private FacebookClient facebookClient;

  public com.tuto.vle.domain.User getViewerData(String accessToken) {
    User user = null;
    try {
      facebookClient = new DefaultFacebookClient(accessToken, Version.VERSION_2_7);
      user = facebookClient.fetchObject("me", User.class,
          Parameter.with("fields", "birthday,email,cover,name,gender,locale,location,hometown"));
    } catch (Exception e) {
      System.out.println(e);
    }
    com.tuto.vle.domain.User userdto = new com.tuto.vle.domain.User();
    userdto.setEmail(user.getEmail());
    userdto.setFirstName(user.getFirstName());
    return userdto;
  }
}
