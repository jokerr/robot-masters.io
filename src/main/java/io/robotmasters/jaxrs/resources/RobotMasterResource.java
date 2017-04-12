package io.robotmasters.jaxrs.resources;

import io.robotmasters.beans.RobotMasterService;
import io.robotmasters.domain.RobotMaster;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import java.util.List;

/**
 * @author jokerr
 */
@Path("robot-master")
public class RobotMasterResource {

    @Autowired
    private RobotMasterService service;

    @GET
    public List<RobotMaster> findRobotMaster(
            @QueryParam("name") String name,
            @QueryParam("weapon") String weapon,
            @QueryParam("end") Double endurance,
            @QueryParam("int") Double intelligence,
            @QueryParam("spd") Double speed,
            @QueryParam("bat") Double battle) {
        return service.search(name, weapon, endurance, intelligence, speed, battle);
    }

    @GET
    @Path("{id}")
    public RobotMaster findRobotMaster(@PathParam("id") String id) {
        RobotMaster robotMaster = service.find(id);
        if(robotMaster == null) {
            throw new NotFoundException("Robot Master '" + id + "' not found");
        }
        return robotMaster;
    }

    @DELETE
    @Path("{id}")
    public void deleteRobotMaster(@PathParam("id") String id) {
        service.delete(findRobotMaster(id));
    }
}
