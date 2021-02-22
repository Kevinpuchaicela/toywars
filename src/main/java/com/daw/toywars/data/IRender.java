package com.daw.toywars.data;

public interface IRender {
    public String doRender(RenderType renderType);
    public void setNormalView();
    public void setView(RenderType renderType, String content);
}
