package com.tuto.vle.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tuto.vle.domain.Lesson;
import com.tuto.vle.dto.LatestLessonDTO;
import com.tuto.vle.dto.LessonDto;
import com.tuto.vle.exception.CustomException;
import com.tuto.vle.exception.ResourceNotFoundException;
import com.tuto.vle.repositories.LessonRepository;
import com.tuto.vle.util.Constants;
import com.tuto.vle.util.CustomErrorCodes;

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

  public LessonDto getLessonDetailsByLessonId(Integer userId, Integer lessonId) throws Exception {

    Lesson lesson = lessonRepository.findByUserIDANDLessonId(userId, lessonId);

    if (lesson == null)
      throw new CustomException(CustomErrorCodes.LESSON_NOT_FOUND);

    return new LessonDto(lesson);
  }

  public List<LessonDto> getLessonDetailsByModuleId(Integer userId, Integer moduleId)
      throws Exception {

    List<Lesson> lessons = lessonRepository.findLessonsByUserIDANDModuleId(userId, moduleId);

    if (lessons.isEmpty())
      throw new CustomException(CustomErrorCodes.LESSON_NOT_FOUND);

    return lessons.stream().map(LessonDto::new).collect(Collectors.toList());
  }

}

