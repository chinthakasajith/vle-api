package com.tuto.vle.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.tuto.vle.dto.DivisionDto;
import com.tuto.vle.dto.UniversityDto;
import com.tuto.vle.exception.ResourceNotFoundException;
import com.tuto.vle.service.UniversityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Api(value = "University Controller", description = "Used for get university endpoints")
public class UniversityController {

  @Autowired
  private UniversityService universityService;

  @ApiOperation(value = "View a list of available Universities", response = UniversityDto.class,
      responseContainer = "List")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "Content-Type", value = "application/json", paramType = "header"),
      @ApiImplicitParam(name = "bearer-access-token", value = "Generated access token",
          paramType = "header")})
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved list"),
      @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
      @ApiResponse(code = 403,
          message = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
  @GetMapping("/universities")
  @ResponseStatus(HttpStatus.OK)
  public List<UniversityDto> getAllUniversities(
      @ApiIgnore @RequestAttribute("mobile-user-id") Integer mobileUserId)
      throws ResourceNotFoundException {
    return universityService.getModulesByUserId(mobileUserId);
  }

  @GetMapping("/universities/{id}")
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Get university details with university id", response = UniversityDto.class)
  @ApiImplicitParams({
      @ApiImplicitParam(name = "Content-Type", value = "application/json", paramType = "header"),
      @ApiImplicitParam(name = "bearer-access-token", value = "Generated access token",
          paramType = "header")})
  public UniversityDto getUniversityDetailsByUniversityId(
      @ApiIgnore @RequestAttribute("mobile-user-id") Integer mobileUserId,
      @PathVariable("id") int id) throws ResourceNotFoundException {
    return universityService.getUniversityDetailsByUniversityId(mobileUserId, id);
  }

  @GetMapping("/universities/{id}/divisions")
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Get division details with university id", response = DivisionDto.class,
      responseContainer = "List")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "Content-Type", value = "application/json", paramType = "header"),
      @ApiImplicitParam(name = "bearer-access-token", value = "Generated access token",
          paramType = "header")})
  public List<DivisionDto> getDivisionDetailsByUniversityId(
      @ApiIgnore @RequestAttribute("mobile-user-id") Integer mobileUserId,
      @PathVariable("id") int id) throws ResourceNotFoundException {
    return universityService.getDivisionDetailsByUniversityId(mobileUserId, id);
  }

}
