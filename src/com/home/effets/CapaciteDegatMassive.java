package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.carte.Serviteur;
import com.home.effets.Capacite;
import com.home.exception.noLifeException;

import java.util.ArrayList;

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
    public String toString() {
        return super.toString() + "degats :" + this.degat;
    }
}
