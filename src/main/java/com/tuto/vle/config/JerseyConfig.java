package com.tuto.vle.config;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import com.tuto.vle.endpoint.UniversityEndpoint;

@Component
@ApplicationPath("/tuto")
public class JerseyConfig extends ResourceConfig{
  public JerseyConfig() {
    register(UniversityEndpoint.class);
   }

}
