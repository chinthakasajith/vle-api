package com.tuto.vle.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.tuto.vle.dto.DivisionDto;
import com.tuto.vle.dto.UniversityDto;
import com.tuto.vle.exception.ResourceNotFoundException;
import com.tuto.vle.service.UniversityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "University Controller", description = "Used for get university endpoints")
public class UniversityController {

  // TODO Since authentication not implement yet
  final static Integer USER_ID = 1;

  @Autowired
  private UniversityService universityService;

  @ApiOperation(value = "View a list of available Universities", response = UniversityDto.class,
      responseContainer = "List")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved list"),
      @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
      @ApiResponse(code = 403,
          message = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
  @GetMapping("/universities")
  @ResponseStatus(HttpStatus.OK)
  public List<UniversityDto> getAllUniversities() throws ResourceNotFoundException {
    return universityService.getUniversitiesByUserId(USER_ID);
  }

  @GetMapping("/universities/{id}")
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Get university details with university id", response = UniversityDto.class,
      responseContainer = "List")
  public List<UniversityDto> getUniversityDetailsByUniversityId(@PathVariable("id") int id)
      throws ResourceNotFoundException {
    return universityService.getUniversityDetailsByUniversityId(USER_ID, id);
  }

  @GetMapping("/universities/{id}/divisions")
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Get division details with university id", response = DivisionDto.class,
      responseContainer = "List")
  public List<DivisionDto> getDivisionDetailsByUniversityId(@PathVariable("id") int id)
      throws ResourceNotFoundException {
    return universityService.getDivisionDetailsByUniversityId(USER_ID, id);
  }

}
