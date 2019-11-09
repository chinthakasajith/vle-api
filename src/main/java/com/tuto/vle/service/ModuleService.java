package com.tuto.vle.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tuto.vle.domain.Module;
import com.tuto.vle.dto.ModuleDto;
import com.tuto.vle.exception.CustomException;
import com.tuto.vle.exception.ResourceNotFoundException;
import com.tuto.vle.repositories.ModuleRepository;
import com.tuto.vle.util.Constants;
import com.tuto.vle.util.CustomErrorCodes;

@Service
public class ModuleService {

  @Autowired
  ModuleRepository moduleRepository;

  public List<ModuleDto> getModulesByUserId(Integer userId) throws Exception {

    List<Module> modules = moduleRepository.findByUserID(userId, Constants.MODULE_RESOURCE_ID);

    if (modules.isEmpty())
      throw new ResourceNotFoundException(
          "No module registered to this user id : " + userId.toString());

    return modules.stream().map(ModuleDto::new).collect(Collectors.toList());

  }

  public ModuleDto getModuleDetailsByModuleId(Integer userId, Integer moduleId) throws Exception {

    Module module =
        moduleRepository.findByUserIDANDModuleId(userId, Constants.MODULE_RESOURCE_ID, moduleId);

    if (module == null)
      throw new CustomException(CustomErrorCodes.MODULE_NOT_FOUND);

    return new ModuleDto(module);
  }

  public List<ModuleDto> getModuleDetailsByCourseId(Integer userId, Integer courseId)
      throws Exception {

    List<Module> modules = moduleRepository.findModulesByUserIDANDCourseId(userId, courseId);

    if (modules.isEmpty())
      throw new CustomException(CustomErrorCodes.MODULE_NOT_FOUND);

    return modules.stream().map(ModuleDto::new).collect(Collectors.toList());
  }

}

