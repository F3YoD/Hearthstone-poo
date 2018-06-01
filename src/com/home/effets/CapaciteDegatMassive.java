package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.carte.Serviteur;
import com.home.effets.Capacite;
import com.home.exception.noLifeException;

public class CapaciteDegatMassive extends Capacite {

    private int degat;


    public CapaciteDegatMassive(int pDegat){
        super("DegatMassive");
        this.degat = pDegat;
    }

    @Override
    public void realiser(Carte lanceur,Plateau pPlateau) {
        for(Serviteur s: pPlateau.joueurAAttaquer().getTerrain().getLstCarte()){
            try {
                s.prendDamage(this.degat);
            }catch (noLifeException e){
                pPlateau.joueurAAttaquer().getTerrain().getLstCarte().remove(this);
            }
        }
    }


    @Override
    public String toString() {
        return super.toString() + "degats :" + this.degat;
    }
}
