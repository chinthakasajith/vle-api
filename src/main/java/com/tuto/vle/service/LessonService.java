package com.tuto.vle.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tuto.vle.domain.Lesson;
import com.tuto.vle.dto.LatestLessonDTO;
import com.tuto.vle.dto.LessonDto;
import com.tuto.vle.exception.ResourceNotFoundException;
import com.tuto.vle.repositories.LessonRepository;
import com.tuto.vle.util.Constants;

@Service
public class LessonService {

  @Autowired
  LessonRepository lessonRepository;

  public List<LatestLessonDTO> getLessonsByUserId(Integer userId) throws ResourceNotFoundException {

    List<LatestLessonDTO> lessons =
        lessonRepository.findByUserID(userId, Constants.LESSON_RESOURCE_ID);

    if (lessons.isEmpty())
      throw new ResourceNotFoundException(
          "No module registered to this user id : " + userId.toString());

    return lessons;

  }

  public LessonDto getLessonDetailsByLessonId(Integer userId, Integer lessonId)
      throws ResourceNotFoundException {

    Lesson lesson = lessonRepository.findByUserIDANDLessonId(userId, lessonId);

    if (lesson == null)
      throw new ResourceNotFoundException("No lesson registered to this user id : "
          + userId.toString() + " lesson id : " + lessonId);

    return new LessonDto(lesson);
  }

  public List<LessonDto> getLessonDetailsByModuleId(Integer userId, Integer moduleId)
      throws ResourceNotFoundException {

    List<Lesson> lessons = lessonRepository.findLessonsByUserIDANDModuleId(userId, moduleId);

    if (lessons.isEmpty())
      throw new ResourceNotFoundException("No lesson registered to this user id : "
          + userId.toString() + " module id : " + moduleId);

    return lessons.stream().map(LessonDto::new).collect(Collectors.toList());
  }

}

