package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.exception.mauvaisIdException;

public class AttaqueMentale extends Capacite{
    int degats;

    public AttaqueMentale(int degats){
        super("attaque mental : inflige 5 points de degat au hero");
        this.setDegats(5);
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    @Override
    public void realiser(Carte lanceur, Plateau pPlateau, int pIdLanceur) throws mauvaisIdException {
        pPlateau.joueurAAttaquer(pIdLanceur).getHero().addVies(- this.degats);
    }
}
