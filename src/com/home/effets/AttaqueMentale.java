package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.exception.noLifeException;

/**
 * <b>AttaqueMentale hérite de Capacite et est une Capacite Particulière</b>
 * <p>
 * elle provoque des dégats au hero adverse
 * </p>
 * @author yoann/pierre
 */
public class AttaqueMentale extends Capacite{
    private int degats;

    public AttaqueMentale(int degats){
        super("attaque mentale");
        this.setDegats(degats);
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    @Override
    public void realiser(Carte lanceur, Plateau pPlateau){
        try{
        pPlateau.joueurAAttaquer().getHero().prendDegats(this.degats);
        }catch (noLifeException e){
            System.out.println(pPlateau.joueurActuel().getHero().getNom()+ "gagne \n");
            System.exit(0);
        }
    }
}
