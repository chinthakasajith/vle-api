package com.tuto.vle.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.tuto.vle.dto.CourseDto;
import com.tuto.vle.exception.ResourceNotFoundException;
import com.tuto.vle.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Course Controller", description = "Used for get course endpoints")
public class CourseController {

  // TODO Since authentication not implement yet
  final static Integer USER_ID = 1;

  @Autowired
  private CourseService courseService;

  @ApiOperation(value = "View a list of available Courses", response = CourseDto.class,
      responseContainer = "List")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved list"),
      @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
      @ApiResponse(code = 403,
          message = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
  @GetMapping("/courses")
  @ResponseStatus(HttpStatus.OK)
  public List<CourseDto> getCoursesByUserId(
      @ApiParam(value = "recommend", required = false) @RequestParam(required = false) String type,
      @ApiParam(value = "new/interest/subscription",
          required = false) @RequestParam(required = false) String filter)
      throws ResourceNotFoundException {
    return courseService.getCoursesByUserId(USER_ID, type, filter);
  }

  @ApiOperation(value = "Get course with course id", response = CourseDto.class,
      responseContainer = "List")
  @GetMapping("/courses/{id}")
  @ResponseStatus(HttpStatus.OK)
  public List<CourseDto> getCourseDetailsByUniversityId(@PathVariable("id") int id)
      throws ResourceNotFoundException {
    return courseService.getCourseDetailsByUniversityId(USER_ID, id);
  }

}
