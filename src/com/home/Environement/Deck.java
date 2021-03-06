package com.home.Environement;

import com.home.carte.Carte;
import com.home.carte.Serviteur;
import com.home.exception.noCarteException;

import java.util.ArrayList;
import java.util.Objects;

/**
 * <b>la class Capacite est la liste de carte que possede le joueur</b>
 * @author yoann/pierre
 */
public class Deck {
    // ================================================================== \\
    // =========================== ATTRIBUTS ============================ \\
    // ================================================================== \\
    private ArrayList<Carte> lstCarte;

    public Deck(){
        this.lstCarte = new ArrayList<Carte>();
    }

    public boolean add(Carte pCarte){
        return this.lstCarte.add(pCarte);
    }

    public String toString(){
        String fin="";
        for (Carte i : this.lstCarte){
            fin += i.toString() +"\n";
        }
        return fin;
    }

    public ArrayList<Carte> getLstCarte() {
        return lstCarte;
    }

    public void setLstCarte(ArrayList<Carte> lstCarte) {
        this.lstCarte = lstCarte;
    }

    public boolean estPresente(String nom){
        for (Carte c : this.lstCarte){
            if (c.getNom().trim().equals(nom)){
                return true;
            }
        }
        return false;
    }

    public Carte Findwithname(String nom) throws noCarteException {
        Serviteur fin= new Serviteur();
        if (!this.estPresente(nom)){
            throw new noCarteException("Cette carte n'existe pas");
        }
        for(Carte c : this.lstCarte){
            if (c.getNom().trim().equals(nom)){
                return c;
            }
        }
        return fin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Deck)) return false;
        Deck deck = (Deck) o;
        return Objects.equals(getLstCarte(), deck.getLstCarte());
    }

}
