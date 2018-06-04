package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.carte.Serviteur;
import com.home.effets.Capacite;
import com.home.exception.noLifeException;

import java.util.ArrayList;
import java.util.Objects;

/**
 * <b>CapaciteDegatMassive hérite de Capacite et est une Capacite Particulière</b>
 * <p>
 * elle provoque des degats a toutes les cartes adverse présente sur le terrain
 * </p>
 * @author yoann/pierre
 */
public class CapaciteDegatMassive extends Capacite {

    private int degat;


    public CapaciteDegatMassive(int pDegat){
        super("DegatMassive");
        this.degat = pDegat;
    }

    @Override
    public void realiser(Carte lanceur,Plateau pPlateau) {
        ArrayList<Serviteur> rm =new ArrayList<Serviteur>();
        for(Serviteur s: pPlateau.joueurAAttaquer().getTerrain().getLstCarte()){
            try {
                s.prendDamage(this.degat);
            }catch (noLifeException e){
                rm.add(s);
            }
        }
        for (Serviteur s : rm){
            pPlateau.joueurAAttaquer().getTerrain().getLstCarte().remove(s);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CapaciteDegatMassive)) return false;
        if (!super.equals(o)) return false;
        CapaciteDegatMassive that = (CapaciteDegatMassive) o;
        return degat == that.degat;
    }

    @Override
    public String toString() {
        return "CapaciteDegatMassive{" +
                "degat=" + degat +
                ", description='" + description + '\'' +
                '}';
    }
}
