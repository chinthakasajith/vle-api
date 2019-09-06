package com.tuto.vle.endpoint;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tuto.vle.domain.University;
import com.tuto.vle.repositories.UniversityRepository;
import com.tuto.vle.service.UniversityService;
import com.tuto.vle.service.UserResourceMembershipsService;

@Component
@Path("/universities")
public class UniversityEndpoint {
  
  @Autowired
  UserResourceMembershipsService userResourceMembershipsService;
  
  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getUniversityDetails() {
    
    List<University> universities=new ArrayList<University>();
    return Response.ok(userResourceMembershipsService.getUniversitiesByUserId(1)).build();    
    
  }

}
