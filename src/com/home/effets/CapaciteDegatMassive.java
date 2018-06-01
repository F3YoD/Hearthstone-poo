package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.carte.Serviteur;
import com.home.effets.Capacite;

public class CapaciteDegatMassive extends Capacite {

    private int degat;


    public CapaciteDegatMassive(int pDegat){
        super("DegatMassive");
        this.degat = pDegat;
    }

    @Override
    public void realiser(Carte lanceur,Plateau pPlateau) {
        for(Serviteur s: pPlateau.joueurAAttaquer().getTerrain().getLstCarte()){
            s.addVies(-degat);
        }
    }


    @Override
    public String toString() {
        return super.toString() + "degats :" + this.degat;
    }
}
