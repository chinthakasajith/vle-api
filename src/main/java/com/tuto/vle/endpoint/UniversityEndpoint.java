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
import com.tuto.vle.dto.UniversityDto;
import com.tuto.vle.exception.ResourceNotFoundException;
import com.tuto.vle.service.UniversityService;

@Component
@Path("/universities")
public class UniversityEndpoint {


  // TODO Since authentication not implement yet
  final static Integer USER_ID = 189;

  @Autowired
  UniversityService universityService;

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public ResponseEntity<?> getUniversityDetails() throws ResourceNotFoundException {

    List<UniversityDto> universities = universityService.getUniversitiesByUserId(USER_ID);

    if (universities.isEmpty()) {
      String errors = "No University is registered to user id : " + USER_ID;
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }

    return ResponseEntity.ok(universities);

  }

  @GET
  @Path("/{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public ResponseEntity<?> getUniversityDetailsByUniversityId(@PathParam("id") int id) {
    List<UniversityDto> universities =
        universityService.getUniversityDetailsByUniversityId(USER_ID, id);
    if (universities.isEmpty()) {
      String errors = "No University is found to university id : " + id;
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }

    return ResponseEntity.ok(universities);
  }

  @GET
  @Path("/{id}/divisions")
  @Produces(MediaType.APPLICATION_JSON)
  public ResponseEntity<?> getDivisionDetailsByUniversityId(@PathParam("id") int id) {

    List<DivisionDto> divisions = universityService.getDivisionDetailsByUniversityId(USER_ID, id);
    if (divisions.isEmpty()) {
      String errors = "No Division is found to university id : " + id;
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }

    return ResponseEntity.ok(divisions);

  }

}
