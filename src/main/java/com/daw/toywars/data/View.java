package com.daw.toywars.data;

import com.daw.toywars.data.puppets.AsciiArt;

public class View {
    private String viewHTML;
    private String viewConsole;
    private String viewJSON;

    public View(){
        this.viewHTML = AsciiArt.normal();
        this.viewConsole = AsciiArt.normal();
        this.viewJSON = AsciiArt.normal();
    }

    public View(String viewHTML, String viewConsole, String viewJSON) {
        this.viewHTML = viewHTML;
        this.viewConsole = viewConsole;
        this.viewJSON = viewJSON;
    }

    public String getViewHTML() {
        return viewHTML;
    }

    public void setViewHTML(String viewHTML) {
        this.viewHTML = viewHTML;
    }

    public String getViewConsole() {
        return viewConsole;
    }

    public void setViewConsole(String viewConsole) {
        this.viewConsole = viewConsole;
    }

    public String getViewJSON() {
        return viewJSON;
    }

    public void setViewJSON(String viewJSON) {
        this.viewJSON = viewJSON;
    }
}
