package com.tuto.vle.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tuto.vle.domain.Division;
import com.tuto.vle.domain.University;
import com.tuto.vle.dto.DivisionDto;
import com.tuto.vle.dto.UniversityDto;
import com.tuto.vle.exception.CustomException;
import com.tuto.vle.exception.ResourceNotFoundException;
import com.tuto.vle.repositories.UniversityRepository;
import com.tuto.vle.util.Constants;
import com.tuto.vle.util.CustomErrorCodes;

@Service
public class UniversityService {

  @Autowired
  UniversityRepository universityRepository;

  public List<UniversityDto> getModulesByUserId(Integer userId) throws ResourceNotFoundException {

    List<University> universities =
        universityRepository.findByUserID(userId, Constants.UNIVERSITY_RESOURCE_ID);

    if (universities.isEmpty())
      throw new ResourceNotFoundException(
          "No university registered to this user id : " + userId.toString());

    return universities.stream().map(UniversityDto::new).collect(Collectors.toList());

  }

  public UniversityDto getUniversityDetailsByUniversityId(Integer userId, Integer universityId)
      throws Exception {

    List<University> universities = universityRepository.findByUserIDANDUniversityId(userId,
        Constants.UNIVERSITY_RESOURCE_ID, universityId);

    if (universities.isEmpty())
      throw new CustomException(CustomErrorCodes.UNIVERSITY_NOT_FOUND);

    return universities.stream().map(UniversityDto::new).collect(toSingleton());
  }

  public List<DivisionDto> getDivisionDetailsByUniversityId(Integer userId, Integer universityId)
      throws Exception {

    List<Division> dividions = universityRepository.findDivisionsByUserIDANDUniversityId(userId,
        Constants.UNIVERSITY_RESOURCE_ID, universityId);

    if (dividions.isEmpty())
      throw new CustomException(CustomErrorCodes.UNIVERSITY_NOT_FOUND);

    return dividions.stream().map(DivisionDto::new).collect(Collectors.toList());
  }

  public static <T> Collector<T, ?, T> toSingleton() {
    return Collectors.collectingAndThen(Collectors.toList(), list -> {
      if (list.size() != 1) {
        throw new IllegalStateException();
      }
      return list.get(0);
    });
  }

}

