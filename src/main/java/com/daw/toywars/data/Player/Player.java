package com.daw.toywars.data.Player;

import com.daw.toywars.data.LifeBeing;

import java.util.List;

public class Player {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private List<LifeBeing> puppets;

    public Player(Integer id, String name, String email, String password, List<LifeBeing> puppets) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.puppets = puppets;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<LifeBeing> getPuppets() {
        return puppets;
    }

    public void setPuppets(List<LifeBeing> puppets) {
        this.puppets = puppets;
    }
    public void addPuppet(LifeBeing puppet){
        this.puppets.add(puppet);
    }
}
