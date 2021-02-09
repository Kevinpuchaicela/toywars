package com.daw.toywars.data;

public class UserAction {
    private LifeBeing puppet;
    private Status status;

    public UserAction(LifeBeing puppet, Status status) {
        this.puppet = puppet;
        this.status = status;
    }

    public LifeBeing getPuppet() {
        return puppet;
    }

    public void setPuppet(LifeBeing puppet) {
        this.puppet = puppet;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
