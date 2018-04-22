package com.home.effets;

/*
enum Comportement {

}
*/

public class Capacite {

    private String description;
    public Capacite(String pDesc){
        this.setDescription(pDesc);
    }

    private void setDescription(String pDesc){
        if(!pDesc.trim().equals(""))
            throw new IllegalArgumentException();

        this.description = pDesc;
    }
}
