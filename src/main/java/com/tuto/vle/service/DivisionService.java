package com.tuto.vle.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tuto.vle.domain.Division;
import com.tuto.vle.dto.DivisionDto;
import com.tuto.vle.exception.ResourceNotFoundException;
import com.tuto.vle.repositories.DivisionRepository;
import com.tuto.vle.util.Constants;

@Service
public class DivisionService {

  @Autowired
  DivisionRepository divisionRepository;

  public List<DivisionDto> getDivisionsByUserId(Integer userId) throws ResourceNotFoundException {

    List<Division> divisions =
        divisionRepository.findByUserID(userId, Constants.UNIVERSITY_RESOURCE_ID);

    if (divisions.isEmpty())
      throw new ResourceNotFoundException(
          "No division registered to this user id : " + userId.toString());

    return divisions.stream().map(DivisionDto::new).collect(Collectors.toList());
  }

  public List<DivisionDto> getDivisionDetailsByUniversityId(Integer userId, Integer divisionId)
      throws ResourceNotFoundException {

    List<Division> divisions = divisionRepository.findByUserIDANDDivisionId(userId,
        Constants.UNIVERSITY_RESOURCE_ID, divisionId);

    if (divisions.isEmpty())
      throw new ResourceNotFoundException("No division registered to this user id : "
          + userId.toString() + " division id : " + divisionId);

    return divisions.stream().map(DivisionDto::new).collect(Collectors.toList());
  }

}
