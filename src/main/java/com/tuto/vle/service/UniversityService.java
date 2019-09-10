package com.tuto.vle.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tuto.vle.domain.Division;
import com.tuto.vle.domain.University;
import com.tuto.vle.dto.DivisionDto;
import com.tuto.vle.dto.UniversityDto;
import com.tuto.vle.repositories.UniversityRepository;
import com.tuto.vle.util.Constants;

@Service
public class UniversityService {

  @Autowired
  UniversityRepository universityRepository;

  public List<UniversityDto> getUniversitiesByUserId(Integer userId) {

    List<University> universities =
        universityRepository.findByUserID(userId, Constants.UNIVERSITY_RESOURCE_ID);

    return universities.stream().map(UniversityDto::new).collect(Collectors.toList());

  }

  public List<UniversityDto> getUniversityDetailsByUniversityId(Integer userId,
      Integer universityId) {

    List<University> universities = universityRepository.findByUserIDANDUniversityId(userId,
        Constants.UNIVERSITY_RESOURCE_ID, universityId);

    return universities.stream().map(UniversityDto::new).collect(Collectors.toList());
  }

  public List<DivisionDto> getDivisionDetailsByUniversityId(Integer userId, Integer universityId) {

    List<Division> dividions = universityRepository.findDivisionsByUserIDANDUniversityId(userId,
        Constants.UNIVERSITY_RESOURCE_ID, universityId);

    return dividions.stream().map(DivisionDto::new).collect(Collectors.toList());
  }

}

