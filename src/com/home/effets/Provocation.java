package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.carte.Serviteur;

import java.util.Scanner;


/**
 * <b>Provocation hérite de Capacite et est une Capacite Particulière</b>
 * <p>
 * elle met a 1 la priorité de la carte possèdant cette capacite
 * </p>
 * @author yoann/pierre
 */
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
        return "Provocation{" +
                "description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
