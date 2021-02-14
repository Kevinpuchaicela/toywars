package com.daw.toywars.data;

public class UserAction {
    private LifeBeing puppet;

    public UserAction(LifeBeing puppet) {
        this.puppet = puppet;
    }

    public LifeBeing getPuppet() {
        return puppet;
    }

    public void setPuppet(LifeBeing puppet) {
        this.puppet = puppet;
    }

}
