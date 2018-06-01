package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Serviteur;

import java.util.ArrayList;

public class Charge extends Capacite {

    public Charge(String description){
        super();
        this.type="Charge";
        this.setDescription(description);
    }
    public void setDescription(String desc){
        this.description = desc;
    }

    @Override
    public void realiser(Plateau pPlateau, int pIdLanceur) {
        
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
    public void realiser(Serviteur serv, ArrayList<Serviteur> lst){
        serv.setAttente(serv.getAttente() -1);
    }
}
