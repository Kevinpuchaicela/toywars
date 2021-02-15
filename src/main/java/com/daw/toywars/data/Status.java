package com.daw.toywars.data;

public class Status {
    private Integer healthPoints;
    private Integer experiencePoints;

    public Status() {}

    public Status(Integer healthPoints, Integer experiencePoints) {
        this.healthPoints = healthPoints;
        this.experiencePoints = experiencePoints;
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(Integer healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Integer getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(Integer experiencePoints) {
        this.experiencePoints = experiencePoints;
    }


}
