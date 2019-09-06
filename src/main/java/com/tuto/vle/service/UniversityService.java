package com.tuto.vle.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tuto.vle.domain.University;
import com.tuto.vle.repositories.UniversityRepository;

@Component
public class UniversityService {
  @Autowired
  UniversityRepository universityRepository;
  
  public List<University> getUniversitiesByUserId() {
    return universityRepository.findAll();
  }

}
