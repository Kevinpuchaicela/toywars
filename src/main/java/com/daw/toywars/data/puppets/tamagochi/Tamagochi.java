package com.daw.toywars.data.puppets.tamagochi;

import com.daw.toywars.data.IRender;
import com.daw.toywars.data.RenderType;
import org.apache.commons.lang3.StringUtils;

public class Tamagochi  implements IRender {
    private TamaType tamaType;

    public Tamagochi(TamaType tamaType) {
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
}
