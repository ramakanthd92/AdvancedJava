package com.adobe.prj.entity;

public class Mobile extends Product {
    private String connectivity;

    public Mobile() {
    }

    public Mobile(int id, String name, double price, String type,String connectivity) {
        super(id, name, price,type);
        this.connectivity = connectivity;
    }

    public String getConnectivity() {
        return connectivity;
    }

    public boolean isExpensive(){
        if (price > 20000) {
            return true;
        }
        return false;
    }
    public void setConnectivity(String connectivity) {
        this.connectivity = connectivity;
    }

}