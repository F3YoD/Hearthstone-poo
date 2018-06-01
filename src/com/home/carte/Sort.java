package com.home.carte;

import com.home.Environement.Plateau;
import com.home.effets.*;
import com.home.exception.mauvaisIdException;

public class Sort extends Carte {

    private String nom;
    private Capacite capacite;
    private Plateau plateau;

    public Sort(String pNom, int pCout, Capacite pCapacite, Plateau pPlateau){
        super(pNom, pCout);
        this.capacite = pCapacite;
        this.plateau = pPlateau;
    }

    public void lancer() throws mauvaisIdException {
        capacite.realiser(this,plateau, plateau.getIdJoueurActuel());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
