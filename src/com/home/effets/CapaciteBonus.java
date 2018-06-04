package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.carte.Serviteur;

import java.util.Objects;

/**
 * <b>CapaciteBonus hérite de Capacite et est une Capacite Particulière</b>
 * <p>
 * elle ajoute de l'attaque et de la vie au cartes présentes sur le terrain allié
 * </p>
 * @author yoann/pierre
 */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CapaciteBonus)) return false;
        if (!super.equals(o)) return false;
        CapaciteBonus that = (CapaciteBonus) o;
        return paBonus == that.paBonus &&
                pvBonus == that.pvBonus &&
                Objects.equals(nom, that.nom);
    }

    @Override
    public String toString() {
        return "CapaciteBonus{" +
                "paBonus=" + paBonus +
                ", pvBonus=" + pvBonus +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
