package io.robotmasters.beans;

import io.robotmasters.domain.RobotMaster;
import io.robotmasters.repository.RobotMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author jokerr
 */
@Service
public class RobotMasterService {

    @Autowired
    private RobotMasterRepository repository;

    /**
     * Searches for the {@link RobotMaster} that matches the specified parameters.
     * @param name Name of the robot master
     * @param weapon Weapon of the robot master
     * @param endurance Endurance of the robot master
     * @param intelligence Intelligence of the robot master
     * @param speed Speed of the robot master
     * @param battle Battle Power of the robot master
     * @return An unmodifiable collection of robot masters.
     */
    public List<RobotMaster> search(String name,
                                    String weapon,
                                    Double endurance,
                                    Double intelligence,
                                    Double speed,
                                    Double battle) {
        return Collections.unmodifiableList(repository.search(name, weapon, endurance, intelligence, speed, battle));
    }

    /**
     * Finds the {@link RobotMaster} by ID.
     * @param id ID of the {@link RobotMaster}
     * @return Robot master or null if not found.
     */
    public RobotMaster find(String id) {
        return repository.find(id);
    }
}
