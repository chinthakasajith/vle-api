package com.tuto.vle.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.tuto.vle.dto.DivisionDto;
import com.tuto.vle.exception.ResourceNotFoundException;
import com.tuto.vle.service.DivisionService;
import io.swagger.annotations.Api;

@RestController
@ConditionalOnExpression("${my.controller.enabled:false}")
@Api(value = "Division Controller", description = "Used for get division endpoints")
public class DivisionController {

  // TODO Since authentication not implement yet
  final static Integer USER_ID = 1;

  @Autowired
  private DivisionService divisionService;

  @GetMapping("/divisions")
  @ResponseStatus(HttpStatus.OK)
  public List<DivisionDto> getDivisionDetails() throws ResourceNotFoundException {
    return divisionService.getDivisionsByUserId(USER_ID);
  }

  @GetMapping("/divisions/{id}")
  @ResponseStatus(HttpStatus.OK)
  public List<DivisionDto> getDivisionDetailsByUniversityId(@PathVariable("id") int id)
      throws ResourceNotFoundException {
    return divisionService.getDivisionDetailsByUniversityId(USER_ID, id);
  }

}
