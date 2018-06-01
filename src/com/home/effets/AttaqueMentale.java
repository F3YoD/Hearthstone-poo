package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.exception.mauvaisIdException;

public class AttaqueMentale extends Capacite{

    public AttaqueMentale(){
        super("attaque mental : inflige 5 points de degat au hero");
    }

    @Override
    public void realiser(Carte lanceur, Plateau pPlateau, int pIdLanceur) throws mauvaisIdException {
        int cible;
        if(pIdLanceur == 1)
            cible = 2;
        else
            cible = 1;

        pPlateau.joueurAAttaquer(cible).getHero().addVies(-5);
    }
}
