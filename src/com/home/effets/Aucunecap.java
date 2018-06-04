package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;

/**
 * <b>Aucunecap hérite de Capacite et est une Capacite Particulière</b>
 * <p>
 * c'est pour une carte qui n'a aucune capacite
 * </p>
 * @author yoann/pierre
 */
public class Aucunecap extends Capacite {
    public Aucunecap(){
        super("Aucune");
    }
    public void realiser(Carte lanceur, Plateau pPlateau){}
}
