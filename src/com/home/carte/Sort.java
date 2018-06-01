package com.home.carte;

import com.home.Environement.Plateau;
import com.home.effets.*;
import com.home.exception.lowManaException;
import com.home.exception.mauvaisIdException;

public class Sort extends Carte {

    private String nom;
    private Capacite capacite;

    public Sort(String pNom, int pCout, Capacite pCapacite){
        super(pNom, pCout);
        this.capacite = pCapacite;
    }

    public void lancer(Plateau plateau) throws lowManaException{
        try {
            if (this.getCout() > plateau.joueurActuel(plateau.getIdJoueurActuel()).getHero().getMana()){
                throw new lowManaException("Pas assez de mana");
            }
            //suppression du mana
            plateau.joueurActuel(plateau.getIdJoueurActuel()).getHero().supprMana(this.getCout());
            //on effectue la capacitée
            capacite.realiser(this, plateau, plateau.getIdJoueurActuel());
            //suppression de la carte de la main
            plateau.joueurActuel(plateau.getIdJoueurActuel()).getMain().supprimerCarte(this);
        }catch (mauvaisIdException e){  }    //todo
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
