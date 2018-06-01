package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.carte.Serviteur;

public class CapaciteBonus extends Capacite {
    private int paBonus;
    private int pvBonus;
    private String nom;

    /**
     * Booste les point d'attaque et de vie des alliées
     * @param nom : nom de la capacite
     * @param pa : point d'attaque bonus
     * @param pv : point de vie bonus
     * @author pierre/yoann
     */
    public CapaciteBonus(String nom, int pa, int pv) {
        super("Bonus");
        this.nom=nom;
        this.setPaBonus(pa);
        this.setPvBonus(pv);
    }

    public void setPaBonus(int pa){
        this.paBonus = pa;
    }

    public void setPvBonus(int pv){
        this.pvBonus = pv;
    }

    @Override
    public void realiser(Carte lanceur, Plateau pPlateau)  {
        for(Serviteur item : pPlateau.joueurActuel().getTerrain().getLstCarte()){
            item.addDegats(this.paBonus);
            item.addVies(this.pvBonus);
        }
    }
}
