package com.daw.toywars.data;

import java.util.Date;

public class UserAction {
    private String puppetName;
    private Status currentStatus;
    private Action currentAction;

    public UserAction(String puppetName, Status currentStatus, Action currentAction) {
        this.puppetName = puppetName;
        this.currentStatus = currentStatus;
        this.currentAction = currentAction;
    }

    public Action getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(Action currentAction) {
        this.currentAction = currentAction;
    }

    public String getPuppetName() {
        return puppetName;
    }

    public void setPuppetName(String puppetName) {
        this.puppetName = puppetName;
    }

    public Status getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }
}
