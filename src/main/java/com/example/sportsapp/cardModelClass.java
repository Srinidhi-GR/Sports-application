package com.example.sportsapp;

public class cardModelClass {
    private int sportsImage;
    private String sportsName;

    public cardModelClass(int sportsImage, String sportsName) {
        this.sportsImage = sportsImage;
        this.sportsName = sportsName;
    }

    public int getSportsImage() {
        return sportsImage;
    }

    public void setSportsImage(int sportsImage) {
        this.sportsImage = sportsImage;
    }

    public String getSportsName() {
        return sportsName;
    }

    public void setSportsName(String sportsName) {
        this.sportsName = sportsName;
    }
}
