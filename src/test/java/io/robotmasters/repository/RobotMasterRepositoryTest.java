package io.robotmasters.repository;

import io.robotmasters.domain.RobotMaster;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author jokerr.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RobotMasterRepositoryTest {

    @Autowired
    private RobotMasterRepository repository;

    @Test
    public void search() throws Exception {
        List<RobotMaster> masters = repository.search(null, "buster", null, null, null, null);
        assertNotNull(masters);
        assertEquals(1, masters.size());
        assertEquals("DRN001", masters.get(0).getId());
    }

    @Test
    public void find() throws Exception {
        RobotMaster master = repository.find("DRN001");
        assertNotNull(master);
        assertEquals("Mega Man", master.getName());
    }
}