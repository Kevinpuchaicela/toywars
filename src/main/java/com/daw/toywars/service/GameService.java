package com.daw.toywars.service;

import com.daw.toywars.data.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    public List<UserAction> userActions = new ArrayList<>();
    public int maxPoints = 100;
    public LifeBeing currentLifeBeing;

    public void doAction(Action action) {
        Status status = new Status(action)
        UserAction userAction = new UserAction(currentLifeBeing, status);
    }

    public resetLifeBeing(){

    }


    public void resetLifeBeing() {

    }

    public String render(RenderType renderType) {
        return currentLifeBeing.doRender(renderType);
    }
    public Status getStatus(){
        return userActions;
    }

    public Action getUserActions() {
        return userActions;
    }
}
