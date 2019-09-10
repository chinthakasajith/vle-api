package com.tuto.vle.controller;

import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.tuto.vle.dto.DivisionDto;
import com.tuto.vle.dto.UniversityDto;
import com.tuto.vle.exception.ResourceNotFoundException;
import com.tuto.vle.service.UniversityService;

@RestController
public class UniversityController {

  // TODO Since authentication not implement yet
  final static Integer USER_ID = 1;

  @Autowired
  private UniversityService universityService;

  @GetMapping("/universities")
  @ResponseStatus(HttpStatus.OK)
  public List<UniversityDto> getAllUniversities() throws ResourceNotFoundException {
    return universityService.getUniversitiesByUserId(USER_ID);
  }

  @GetMapping("/universities/{id}")
  @ResponseStatus(HttpStatus.OK)
  public List<UniversityDto> getUniversityDetailsByUniversityId(@PathParam("id") int id)
      throws ResourceNotFoundException {
    return universityService.getUniversityDetailsByUniversityId(USER_ID, id);
  }

  @GetMapping("/universities/{id}/divisions")
  @ResponseStatus(HttpStatus.OK)
  public List<DivisionDto> getDivisionDetailsByUniversityId(@PathParam("id") int id)
      throws ResourceNotFoundException {
    return universityService.getDivisionDetailsByUniversityId(USER_ID, id);
  }

}
