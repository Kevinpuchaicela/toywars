package com.daw.toywars.data.Player;

import com.daw.toywars.data.puppets.Puppet;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Player {
    private String id;
    private String name;
    private String email;
    private String password;
    private List<Puppet> puppets;

    public Player(String name, String email, String password) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.password = password;
        this.puppets = new ArrayList<>();
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

    public List<Puppet> getPuppets() {
        return puppets;
    }

    public void setPuppets(List<Puppet> puppets) {
        this.puppets = puppets;
    }
    public void addPuppet(Puppet puppet){
        this.puppets.add(puppet);
    }
}
