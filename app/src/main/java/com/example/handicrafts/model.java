package com.example.handicrafts;

public class model {

    int image;
    String subtitle;

    public model(int image, String subtitle) {
        this.image = image;
        this.subtitle = subtitle;
    }

    public model() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
