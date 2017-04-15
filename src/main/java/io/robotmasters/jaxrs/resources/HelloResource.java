package io.robotmasters.jaxrs.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author jokerr
 */
@Path("/hello")
public class HelloResource {

    @GET
    public String getGreeting() {
        return "Hello World";
    }
}
