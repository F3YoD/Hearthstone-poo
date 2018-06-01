package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.carte.Serviteur;

public class Provocation extends Capacite {

    public Provocation(){

    }

    @Override
    public void realiser(Plateau pPlateau, int pIdLanceur, Carte pLanceur) {
        ((Serviteur) pLanceur).setAttente(1);
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
