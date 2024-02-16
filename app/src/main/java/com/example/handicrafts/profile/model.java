package com.example.handicrafts.profile;

public class model {

    int arrow,click;
    String text;

    public model(int arrow, String text,int click) {
        this.arrow = arrow;
        this.text = text;
        this.click=click;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public int getArrow() {
        return arrow;
    }

    public void setArrow(int arrow) {
        this.arrow = arrow;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
