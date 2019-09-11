package com.tuto.vle.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tuto.vle.domain.Course;
import com.tuto.vle.dto.CourseDto;
import com.tuto.vle.exception.ResourceNotFoundException;
import com.tuto.vle.repositories.CourseRepository;
import com.tuto.vle.util.Constants;

@Service
public class CourseService {

  @Autowired
  CourseRepository courseRepository;

  public List<CourseDto> getCoursesByUserId(Integer userId) throws ResourceNotFoundException {

    List<Course> courses = courseRepository.findByUserID(userId, Constants.COURSE_RESOURCE_ID);

    if (courses.isEmpty())
      throw new ResourceNotFoundException(
          "No course registered to this user id : " + userId.toString());

    return courses.stream().map(CourseDto::new).collect(Collectors.toList());
  }

  public List<CourseDto> getCourseDetailsByUniversityId(Integer userId, Integer courseId)
      throws ResourceNotFoundException {

    List<Course> courses =
        courseRepository.findByUserIDANDCourseId(userId, Constants.COURSE_RESOURCE_ID, courseId);

    if (courses.isEmpty())
      throw new ResourceNotFoundException("No course registered to this user id : "
          + userId.toString() + " course id : " + courseId);

    return courses.stream().map(CourseDto::new).collect(Collectors.toList());
  }

}
