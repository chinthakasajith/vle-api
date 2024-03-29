package com.tuto.vle.dto;

import com.tuto.vle.domain.University;

public class UniversityDto {
  private Integer id;
  private String name;
  private String description;

  public UniversityDto(University university) {
    this.id = university.getUniversityId();
    this.name = university.getUniversityName();
    this.description = university.getUniversityDescription();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
