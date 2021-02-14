package com.daw.toywars.data;

public class Status {
    private Integer healthPoints;
    private Integer experiencePoints;
    private Action currentAction;

    public Status() {}

    public Status(Integer healthPoints, Integer experiencePoints, Action currentAction) {
        this.healthPoints = healthPoints;
        this.experiencePoints = experiencePoints;
        this.currentAction = currentAction;
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

    public Action getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(Action currentAction) {
        this.currentAction = currentAction;
    }
}
