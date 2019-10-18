package com.tuto.vle.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.tuto.vle.dto.LatestLessonDTO;
import com.tuto.vle.dto.LessonDto;
import com.tuto.vle.exception.ResourceNotFoundException;
import com.tuto.vle.service.LessonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Lesson Controller", description = "Used for get lesson endpoints")
public class LessonController {

  // TODO Since authentication not implement yet
  final static Integer USER_ID = 1;

  @Autowired
  private LessonService lessonService;

  @ApiOperation(value = "View a list of available lessons", response = LatestLessonDTO.class,
      responseContainer = "List")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved list"),
      @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
      @ApiResponse(code = 403,
          message = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
  @GetMapping("/lessons")
  @ResponseStatus(HttpStatus.OK)
  public List<LatestLessonDTO> getAllModules() throws ResourceNotFoundException {
    return lessonService.getLessonsByUserId(USER_ID);
  }

  @GetMapping("/lesson/{id}")
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Get lesson details with lesson id", response = LessonDto.class,
      responseContainer = "List")
  public LessonDto getModuleDetailsByModuleId(@PathVariable("id") int id)
      throws ResourceNotFoundException {
    return lessonService.getLessonDetailsByLessonId(USER_ID, id);
  }

  @GetMapping("/lesson/modules/{id}")
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Get lesson details with module id", response = LessonDto.class,
      responseContainer = "List")
  public List<LessonDto> getLessonDetailsByModuleId(@PathVariable("id") int id)
      throws ResourceNotFoundException {
    return lessonService.getLessonDetailsByModuleId(USER_ID, id);
  }

}
