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

@RestController
public class CourseController {

  // TODO Since authentication not implement yet
  final static Integer USER_ID = 1;

  @Autowired
  private CourseService courseService;

  @GetMapping("/courses")
  @ResponseStatus(HttpStatus.OK)
  public List<CourseDto> getCoursesByUserId(@RequestParam(required = false) String type,
      @RequestParam(required = false) String filter) throws ResourceNotFoundException {
    return courseService.getCoursesByUserId(USER_ID, type, filter);
  }

  @GetMapping("/courses/{id}")
  @ResponseStatus(HttpStatus.OK)
  public List<CourseDto> getCourseDetailsByUniversityId(@PathVariable("id") int id)
      throws ResourceNotFoundException {
    return courseService.getCourseDetailsByUniversityId(USER_ID, id);
  }

}
