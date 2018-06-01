package com.home.effets;

import com.home.Environement.Plateau;
import com.home.Environement.Terrain;
import com.home.carte.Carte;
import com.home.carte.Serviteur;
import com.home.exception.mauvaisIdException;

public class CapaciteBonus extends Capacite {
    private int paBonus;
    private int pvBonus;

    /**
     * Booste les point d'attaque et de vie des alliées
     * @param desc : description de la capacite
     * @param pa : point d'attaque bonus
     * @param pv : point de vie bonus
     * @author pierre/yoann
     */
    public CapaciteBonus(String desc, int pa, int pv) {
        super(desc);
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
    public void realiser(Carte lanceur, Plateau pPlateau, int pIdLanceur) throws mauvaisIdException {
        for(Serviteur item : pPlateau.joueurActuel(pIdLanceur).getTerrain().getLstCarte()){
            item.addDegats(this.paBonus);
            item.addVies(this.pvBonus);
        }
    }
}
