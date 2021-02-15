package com.daw.toywars.data.puppets.tamagochi;

import com.daw.toywars.data.IRender;
import com.daw.toywars.data.LifeBeing;
import com.daw.toywars.data.RenderType;
import com.daw.toywars.data.Status;
import org.apache.commons.lang3.StringUtils;

public class Tamagochi extends LifeBeing implements IRender {
    private TamaType tamaType;

    public Tamagochi(String name, String colorType, Status status, TamaType tamaType) {
        super(name, colorType, status);
        this.tamaType = tamaType;
    }

    public TamaType getTamaType() {
        return tamaType;
    }

    public void setTamaType(TamaType tamaType) {
        this.tamaType = tamaType;
    }

    @Override
    public String doRender(RenderType renderType) {
        String rtn = StringUtils.EMPTY;
        switch (renderType){
            case HTML:
                System.out.println(String.format("<div>%s</div>", "tamagod"));
                break;
            case CONSOLE:
                System.out.println(String.format("TAMAGOCHI : %s", "tamademon"));
            default:
                //rtn=JSONObject.toJSONString();
                break;
        }

        return null;
    }

    @Override
    public void doFeed() {
        super.doFeed();
    }

    @Override
    public void doCleanIt() {
        super.doCleanIt();
    }

    @Override
    public void doWalk() {
        super.doWalk();
    }

    @Override
    public void doPlay() {
        super.doPlay();
    }

    @Override
    public void doSleep() {
        super.doSleep();
    }

    @Override
    public void doFight() {

    }

    @Override
    public void doReset() {

    }

    @Override
    public void doDie() {
        super.doDie();
    }
}
