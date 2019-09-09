package com.tuto.vle.endpoint;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.tuto.vle.dto.DivisionDto;
import com.tuto.vle.service.DivisionService;

@Component
@Path("/divisions")
public class DivisionEndpoint {

  // TODO Since authentication not implement yet
  final static Integer USER_ID = 189;

  @Autowired
  DivisionService divisionService;

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public ResponseEntity<?> getDivisionDetails() {

    List<DivisionDto> divisions = divisionService.getDivisionsByUserId(USER_ID);
    if (divisions.isEmpty()) {
      String errors = "No Division is registered to user id : " + USER_ID;
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }
    return ResponseEntity.ok(divisions);

  }

  @GET
  @Path("/{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public ResponseEntity<?> getDivisionDetailsByUniversityId(@PathParam("id") int id) {

    List<DivisionDto> divisions = divisionService.getDivisionDetailsByUniversityId(USER_ID, id);
    if (divisions.isEmpty()) {
      String errors = "No Division is registered to user id : " + USER_ID;
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }
    return ResponseEntity.ok(divisions);
  }

}
