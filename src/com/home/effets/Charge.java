package com.home.effets;

import com.home.carte.Serviteur;

public class Charge extends Capacite {

    public Charge(String description){
        super();
        this.setDescription(description);
    }
    public void setDescription(String desc){
        this.description = desc;
    }
    public String getDescription(){
        return this.description;
    }
    public boolean equals(){
        //a faire
        return false;
    }
    public String toString(){
        return "description : " + this.description;
    }
    public void realiser(Serviteur serv){
        serv.setAttente(serv.getAttente() -1);
    }
}
