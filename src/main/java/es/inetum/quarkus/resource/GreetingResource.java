package es.inetum.quarkus.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import es.inetum.quarkus.service.GreetingService;

@Path("/hello")
public class GreetingResource {

	@Inject
	GreetingService greetingService;
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greetingService.greet();
    }
}