package com.tuto.vle.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tuto.vle.domain.University;
import com.tuto.vle.repositories.UserResourceMembershipsRepository;
import com.tuto.vle.util.Constants;

@Service
public class UserResourceMembershipsService {
  
  @Autowired
  UserResourceMembershipsRepository userResourceMembershipsRepository;
  
  public List<University> getUniversitiesByUserId(Integer userId) {
    return userResourceMembershipsRepository.findByUserID(userId,Constants.UNIVERSITY_RESOURCE_ID);
  }

}
