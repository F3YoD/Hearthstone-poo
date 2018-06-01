package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.carte.Serviteur;
import com.home.effets.Capacite;

public class CapaciteDegatMassive extends Capacite {

    private int degat;


    public CapaciteDegatMassive(int pDegat){
        this.degat = pDegat;
    }

    @Override
    public void realiser(Plateau pPlateau,  int pIdLanceur) {
        if(pIdLanceur == 1){
            for(Serviteur s : pPlateau.getJoueur1().getTerrain().getLstCarte()){
                s.setDegats(this.degat);
            }

        }else{
            // cible == 2
            for(Serviteur s : pPlateau.getJoueur2().getTerrain().getLstCarte()){
                s.setDegats(this.degat);
            }
        }
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void setDescription(String desc) {

    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals() {
        return false;
    }
}
