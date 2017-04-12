package io.robotmasters.jaxrs.resources;

import io.robotmasters.beans.RobotMasterService;
import io.robotmasters.domain.RobotMaster;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author jokerr
 */
@Path("robot-master")
public class RobotMasterResource {

    @Autowired
    private RobotMasterService service;

    @GET
    @Path("{id}")
    public RobotMaster findRobotMaster(@PathParam("id") String id) {
        return service.find(id);
    }
}
