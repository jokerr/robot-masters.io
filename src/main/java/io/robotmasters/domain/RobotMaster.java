package io.robotmasters.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author jokerr
 */
@Entity
@Table(name = "robots")
@XmlRootElement()
@XmlType(propOrder = {"id", "name", "weapon", "endurance", "intelligence", "speed", "battle"})
public class RobotMaster {
    @Id
    private String id;
    private String name;
    private String weapon;
    private double endurance;
    private double intelligence;
    private double speed;
    private double battle;

    public RobotMaster() {
    }

    public RobotMaster(String id,
                       String name,
                       String weapon,
                       double endurance,
                       double intelligence,
                       double speed,
                       double battle) {
        this.id = id;
        this.name = name;
        this.weapon = weapon;
        this.endurance = endurance;
        this.intelligence = intelligence;
        this.speed = speed;
        this.battle = battle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public double getEndurance() {
        return endurance;
    }

    public void setEndurance(double endurance) {
        this.endurance = endurance;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getBattle() {
        return battle;
    }

    public void setBattle(double battle) {
        this.battle = battle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RobotMaster that = (RobotMaster) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
