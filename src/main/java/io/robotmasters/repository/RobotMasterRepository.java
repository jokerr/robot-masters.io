package io.robotmasters.repository;

import io.robotmasters.domain.RobotMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jokerr
 */
@Repository
public class RobotMasterRepository {

    @Autowired
    private EntityManager em;

    /**
     * Searches the persistence tier for the {@link RobotMaster}s that match the provided parameters.
     * @param name Name of the robot master
     * @param weapon Weapon of the robot master
     * @param endurance Endurance of the robot master
     * @param intelligence Intelligence of the robot master
     * @param speed Speed of the robot master
     * @param battle Battle Power of the robot master
     * @return A collection of robot masters.
     */
    public List<RobotMaster> search(String name,
                                    String weapon,
                                    Double endurance,
                                    Double intelligence,
                                    Double speed,
                                    Double battle) {
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery cq = qb.createQuery();
        Root<RobotMaster> robotMaster = cq.from(RobotMaster.class);

        //Constructing list of parameters
        List<Predicate> predicates = new ArrayList<>();
        if(name != null) {
            predicates.add(qb.like(
                    qb.lower(robotMaster.get("name")),
                    "%" + name.toLowerCase() + "%"));
        }
        if(weapon != null) {
            predicates.add(qb.like(
                    qb.lower(robotMaster.get("weapon")),
                    "%" + weapon.toLowerCase() + "%"));
        }
        if(endurance != null) {
            predicates.add(qb.equal(robotMaster.get("endurance"), endurance));
        }
        if(intelligence != null) {
            predicates.add(qb.equal(robotMaster.get("intelligence"), intelligence));
        }
        if(speed != null) {
            predicates.add(qb.equal(robotMaster.get("speed"), speed));
        }
        if(battle != null) {
            predicates.add(qb.equal(robotMaster.get("battle"), battle));
        }

        //make query and return
        cq.select(robotMaster).where(predicates.toArray(new Predicate[]{}));
        return em.createQuery(cq).getResultList();
    }

    /**
     * Searches the persistence tier for the {@link RobotMaster}.
     * @param id ID of the RobotMaster
     * @return RobotMaster
     * @throws EntityNotFoundException Thrown if the robot master cannot be found
     */
    public RobotMaster find(String id) {
        return em.find(RobotMaster.class, id);
    }

    /**
     * Removes the {@link RobotMaster} from the persistence tier.
     * @param robotMaster RobotMaster to delete
     */
    @Transactional
    public void delete(RobotMaster robotMaster) {
        em.remove(em.merge(robotMaster));
    }
}
