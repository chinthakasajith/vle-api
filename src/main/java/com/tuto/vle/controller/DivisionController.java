package com.tuto.vle.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.tuto.vle.dto.DivisionDto;
import com.tuto.vle.exception.ResourceNotFoundException;
import com.tuto.vle.service.DivisionService;
import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
@ConditionalOnExpression("${my.controller.enabled:false}")
@Api(value = "Division Controller", description = "Used for get division endpoints")
public class DivisionController {

  @Autowired
  private DivisionService divisionService;

  @GetMapping("/divisions")
  @ResponseStatus(HttpStatus.OK)
  public List<DivisionDto> getDivisionDetails(
      @RequestAttribute("mobile-user-id") Integer mobileUserId) throws ResourceNotFoundException {
    return divisionService.getDivisionsByUserId(mobileUserId);
  }

  @GetMapping("/divisions/{id}")
  @ResponseStatus(HttpStatus.OK)
  public List<DivisionDto> getDivisionDetailsByUniversityId(
      @RequestAttribute("mobile-user-id") Integer mobileUserId, @PathVariable("id") int id)
      throws ResourceNotFoundException {
    return divisionService.getDivisionDetailsByUniversityId(mobileUserId, id);
  }

}
