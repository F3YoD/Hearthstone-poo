package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.carte.Serviteur;

import java.util.Scanner;

public class Provocation extends Capacite {

    public Provocation(){
        super("Provocation");
    }

    @Override
    public void realiser(Carte pLanceur, Plateau pPlateau) {
        ((Serviteur) pLanceur).setPriorite(1);
    }

    @Override
    public String getDescription() {
        return "Provocation";
    }

    @Override
    public void setDescription(String desc) {

    }

    @Override
    public String toString() {
        return null;
    }

    public boolean equals() {
        return false;
    }
}
