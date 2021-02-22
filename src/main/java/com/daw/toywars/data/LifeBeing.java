package com.daw.toywars.data;

import java.util.List;

public abstract class LifeBeing {
    private String name;

    public LifeBeing(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
