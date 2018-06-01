package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.carte.Serviteur;

import java.util.ArrayList;

public class Charge extends Capacite {

    public Charge(){
        super("Charge");
    }
    public void setDescription(String desc){
        this.description = desc;
    }

    @Override
    public void realiser(Carte lanceur, Plateau pPlateau) {
        Serviteur lanc =(Serviteur) lanceur;
        lanc.setAttente(0);
    }

    public boolean equals(){
        //a faire
        return false;
    }


}
