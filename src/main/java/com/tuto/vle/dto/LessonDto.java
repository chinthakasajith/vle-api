package com.tuto.vle.dto;

import com.tuto.vle.domain.Lesson;

public class LessonDto {

  public LessonDto(Lesson lesson) {
    this.id = lesson.getId();
    this.description = lesson.getDescription();
    this.lesson_name = lesson.getLessonName();
    this.description = lesson.getDescription();
  }

  private int id;
  private String lesson_name;
  private String status;
  private String description;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLesson_name() {
    return lesson_name;
  }

  public void setLesson_name(String lesson_name) {
    this.lesson_name = lesson_name;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
