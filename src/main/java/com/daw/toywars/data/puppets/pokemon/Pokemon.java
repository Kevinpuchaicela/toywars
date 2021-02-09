package com.daw.toywars.data.puppets.pokemon;

import com.daw.toywars.data.*;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Pokemon extends LifeBeing implements IRender {
    private Status status;


    @Override
    public void doFeed(Action action) {

    }

    @Override
    public void doCleanIt(Action action) {

    }

    @Override
    public void doWalk(Action action) {

    }

    @Override
    public void doPlay(Action action) {

    }

    @Override
    public void doSleep(Action action) {

    }

    @Override
    public void doDie(Action action) {

    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public List<Action> getCurrentActions(Action action) {
        if (status.getCurrentAction().equals(Action.FIGHT)){

        }
            return null;
    }

    @Override
    public String doRender(RenderType renderType) {
        String rtn = StringUtils.EMPTY;
        switch (renderType) {
            case CONSOLE:
                System.out.println(String.format("POKE: %s", "Pikachu"));
                break;
            case HTML:
                rtn = String.format("<div>%s</div>", "Charizard");
                break;
            default:
                //rtn=JSONObject.toJSONString();
                break;
        }
        return null;
    }
}
