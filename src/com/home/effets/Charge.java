package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.carte.Serviteur;
import com.home.exception.noCarteException;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <b>Charge hérite de Capacite et est une Capacite Particulière</b>
 * <p>
 * la carte possèdant cette capacité peut attaqué immédiatement
 * </p>
 * @author yoann/pierre
 */
public class Charge extends Capacite {

    public Charge(){
        super("Charge");
    }
    public void setDescription(String desc){
        this.description = desc;
    }

    @Override
    public void realiser(Carte lanceur, Plateau pPlateau) throws noCarteException {
        Scanner sc = new Scanner(System.in);
        System.out.println("A qui voulez vous appliquer charge ? \n");
        String cherche = sc.nextLine();
        Serviteur cible = pPlateau.joueurActuel().getTerrain().Findwithname(cherche.trim());
        cible.setAttente(0);
    }

    public boolean equals(){
        //a faire
        return false;
    }


}
