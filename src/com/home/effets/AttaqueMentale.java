package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.exception.noLifeException;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AttaqueMentale)) return false;
        if (!super.equals(o)) return false;
        AttaqueMentale that = (AttaqueMentale) o;
        return getDegats() == that.getDegats();
    }

    @Override
    public String toString() {
        return "AttaqueMentale{" +
                "degats=" + degats +
                ", description='" + description + '\'' +
                '}';
    }
}
