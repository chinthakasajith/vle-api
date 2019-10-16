package com.tuto.vle.dto;

import com.tuto.vle.domain.Module;

public class ModuleDto {
  private Integer id;
  private String name;
  private String icon;
  private String description;

  public ModuleDto(Module module) {
    this.id = module.getModuleId();
    this.name = module.getModuleName();
    this.description = module.getDescription();
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

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
