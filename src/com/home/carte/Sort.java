package com.home.carte;

import com.home.Environement.Plateau;
import com.home.effets.*;
import com.home.exception.lowManaException;

public class Sort extends Carte {

    public Sort(String pNom, int pCout, Capacite pCapacite){
        super(pNom, pCout,pCapacite);
    }

    public void lancer(Plateau plateau) throws lowManaException{

            if (this.getCout() > plateau.joueurActuel().getHero().getMana()){
                throw new lowManaException("Pas assez de mana");
            }
            //suppression du mana
            plateau.joueurActuel().getHero().supprMana(this.getCout());
            //on effectue la capacitée
            getCapacite().realiser(this, plateau);
            //suppression de la carte de la main
            plateau.joueurActuel().getMain().supprimerCarte(this);

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
