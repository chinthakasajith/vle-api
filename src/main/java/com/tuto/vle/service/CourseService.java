package com.tuto.vle.service;

import java.util.List;
import java.util.stream.Collector;
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

	public List<CourseDto> getCoursesByUserId(Integer userId, String type, String filter)
			throws ResourceNotFoundException {

		List<Course> courses = null;

		if (type == null && filter == null) {
			courses = courseRepository.findByUserID(userId, Constants.COURSE_RESOURCE_ID);
		} else if (type.equals("recommend") && filter.equals("new")) {
			courses = courseRepository.findNewByUserID(userId, Constants.COURSE_RESOURCE_ID);
		} else if (type.equals("recommend") && filter.equals("interest")) {
			courses = courseRepository.findInterestByUserID(userId, Constants.COURSE_RESOURCE_ID);
		} else if (type.equals("recommend") && filter.equals("subscription")) {
			courses = courseRepository.findSubscriptionByUserID(userId, Constants.COURSE_RESOURCE_ID);
		}

		if (courses.isEmpty())
			throw new ResourceNotFoundException("No course registered to this user id : " + userId.toString());

		return courses.stream().map(CourseDto::new).collect(Collectors.toList());
	}

	public List<CourseDto> getCourseDetailsByUniversityId(Integer userId, Integer courseId)
			throws ResourceNotFoundException {

		List<Course> courses = courseRepository.findByUserIDANDCourseId(userId, Constants.COURSE_RESOURCE_ID, courseId);

		if (courses.isEmpty())
			throw new ResourceNotFoundException(
					"No course registered to this user id : " + userId.toString() + " course id : " + courseId);

		return courses.stream().map(CourseDto::new).collect(Collectors.toList());
	}

	public CourseDto getCourseDetailsByCourseId(Integer userId, Integer courseId)
			throws ResourceNotFoundException {

		List<Course> courses = courseRepository.findByUserIDANDCourseId(userId, Constants.UNIVERSITY_RESOURCE_ID,
				courseId);

		if (courses.isEmpty())
			throw new ResourceNotFoundException(
					"No course registered to this user id : " + userId.toString() + " course id : " + courseId);
		
		return courses.stream().map(CourseDto::new).collect(toSingleton());

	}

	public static <T> Collector<T, ?, T> toSingleton() {
		return Collectors.collectingAndThen(Collectors.toList(), list -> {
			if (list.size() != 1) {
				throw new IllegalStateException();
			}
			return list.get(0);
		});
	}

}
