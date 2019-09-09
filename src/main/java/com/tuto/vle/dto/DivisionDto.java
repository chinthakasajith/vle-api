package com.tuto.vle.dto;

import com.tuto.vle.domain.Division;
import com.tuto.vle.util.Status;

public class DivisionDto {
  private Integer id;
  private String name;
  private String status;

  public DivisionDto(Division division) {
    this.id = division.getDivisionId();
    this.name = division.getDivisionName();
    this.status = division.getStatus() == 1 ? Status.ACTIVE.toString() : Status.DEACTIVE.toString();
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

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
