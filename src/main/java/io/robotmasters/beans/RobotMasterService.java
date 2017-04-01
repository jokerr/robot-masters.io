package io.robotmasters.beans;

import io.robotmasters.domain.RobotMaster;
import io.robotmasters.repository.RobotMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jokerr
 */
@Service
public class RobotMasterService {

    @Autowired
    private RobotMasterRepository repository;

    public List<RobotMaster> search(String name, String weapon, Double endurance, Double intelligence, Double speed, Double battle) {
        return repository.search(name, weapon, endurance, intelligence, speed, battle);
    }

    public RobotMaster find(String id) {
        return repository.find(id);
    }
}
