package com.adobe.prj.entity;

public class Tv extends Product {
    private String screenType;

    public Tv() {
    }

    public Tv(int id, String name, double price,String type, String screenType) {
        super(id, name, price, type);
        this.screenType = screenType;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public boolean isExpensive(){
        if (price > 100000) {
            return true;
        }
        return false;
    }


}