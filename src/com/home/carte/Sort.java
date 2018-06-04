package com.home.carte;

import com.home.Environement.Plateau;
import com.home.effets.*;
import com.home.exception.lowManaException;
import com.home.exception.noCarteException;
import com.home.exception.provocationException;

/**
 * <b>Sort hérite de Carte et est une Carte Particulière</b>
 * @author yoann/pierre
 */
public class Sort extends Carte {

    public Sort(String pNom, int pCout, Capacite pCapacite){
        super(pNom, pCout,pCapacite);
    }

    public void lancer(Plateau plateau) throws lowManaException, provocationException, noCarteException {

            if (this.getCout() > plateau.joueurActuel().getHero().getMana()){
                throw new lowManaException("Pas assez de mana");
            }
            //suppression du mana
            plateau.joueurActuel().getHero().supprMana(this.getCout());
            //on effectue la capacitée
        try {
            getCapacite().realiser(this, plateau);
        }catch (provocationException e){
            plateau.joueurActuel().getHero().addMana(this.getCout());
            throw new provocationException("Une carte provoque");
        }
            //suppression de la carte de la main
            plateau.joueurActuel().getMain().supprimerCarte(this);

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
