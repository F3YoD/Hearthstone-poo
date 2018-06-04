package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.exception.noCarteException;

import java.util.Scanner;

/**
 * <b>MarqueDuChasseur hérite de Capacite et est une Capacite Particulière</b>
 * <p>
 * elle retire 1 point de vie a une carte ciblé
 * </p>
 * @author yoann/pierre
 */
public class MarqueDuChasseur extends Capacite {

    public MarqueDuChasseur(){
        super("Marque du chasseur");
    }

    @Override
    public void realiser(Carte lanceur, Plateau pPlateau) throws noCarteException{
        Scanner sc = new Scanner(System.in);
        System.out.println("A quel serviteur voulez vous reduire les pv a 1 ?  \n ");
        String cherche =sc.nextLine();
        pPlateau.joueurAAttaquer().getTerrain().Findwithname(cherche).setVies(1);
    }

    @Override
    public String toString() {
        return "MarqueDuChasseur{" +
                "description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}

