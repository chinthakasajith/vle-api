package com.tuto.vle.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.tuto.vle.dto.DivisionDto;
import com.tuto.vle.dto.ModuleDto;
import com.tuto.vle.dto.UniversityDto;
import com.tuto.vle.exception.ResourceNotFoundException;
import com.tuto.vle.service.ModuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Module Controller", description = "Used for get module endpoints")
public class ModuleController {

  // TODO Since authentication not implement yet
  final static Integer USER_ID = 1;

  @Autowired
  private ModuleService moduleService;

  @ApiOperation(value = "View a list of available Modules", response = UniversityDto.class,
      responseContainer = "List")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved list"),
      @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
      @ApiResponse(code = 403,
          message = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
  @GetMapping("/modules")
  @ResponseStatus(HttpStatus.OK)
  public List<ModuleDto> getAllModules() throws ResourceNotFoundException {
    return moduleService.getModulesByUserId(USER_ID);
  }

  @GetMapping("/modules/{id}")
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Get module details with module id", response = UniversityDto.class,
      responseContainer = "List")
  public ModuleDto getModuleDetailsByModuleId(@PathVariable("id") int id)
      throws ResourceNotFoundException {
    return moduleService.getModuleDetailsByModuleId(USER_ID, id);
  }

  @GetMapping("/modules/courses/{id}")
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Get division details with university id", response = DivisionDto.class,
      responseContainer = "List")
  public List<ModuleDto> getModuleDetailsByCourseId(@PathVariable("id") int id)
      throws ResourceNotFoundException {
    return moduleService.getModuleDetailsByCourseId(USER_ID, id);
  }

}
