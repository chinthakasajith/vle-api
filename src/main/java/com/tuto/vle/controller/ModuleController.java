package com.tuto.vle.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.tuto.vle.dto.ModuleDto;
import com.tuto.vle.service.ModuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Api(value = "Module Controller", description = "Used for get module endpoints")
public class ModuleController {

  @Autowired
  private ModuleService moduleService;

  @ApiOperation(value = "View a list of available Modules", response = ModuleDto.class,
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
  @GetMapping("/modules")
  @ResponseStatus(HttpStatus.OK)
  public List<ModuleDto> getAllModules(
      @ApiIgnore @RequestAttribute("mobile-user-id") Integer mobileUserId) throws Exception {
    return moduleService.getModulesByUserId(mobileUserId);
  }

  @GetMapping("/modules/{id}")
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Get module details with module id", response = ModuleDto.class)
  @ApiImplicitParams({
      @ApiImplicitParam(name = "Content-Type", value = "application/json", paramType = "header"),
      @ApiImplicitParam(name = "bearer-access-token", value = "Generated access token",
          paramType = "header")})
  public ModuleDto getModuleDetailsByModuleId(
      @ApiIgnore @RequestAttribute("mobile-user-id") Integer mobileUserId,
      @PathVariable("id") int id) throws Exception {
    return moduleService.getModuleDetailsByModuleId(mobileUserId, id);
  }

  @GetMapping("/modules/courses/{id}")
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Get division details with university id", response = ModuleDto.class,
      responseContainer = "List")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "Content-Type", value = "application/json", paramType = "header"),
      @ApiImplicitParam(name = "bearer-access-token", value = "Generated access token",
          paramType = "header")})
  public List<ModuleDto> getModuleDetailsByCourseId(
      @ApiIgnore @RequestAttribute("mobile-user-id") Integer mobileUserId,
      @PathVariable("id") int id) throws Exception {
    return moduleService.getModuleDetailsByCourseId(mobileUserId, id);
  }

}
