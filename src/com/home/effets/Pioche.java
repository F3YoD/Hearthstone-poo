package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.exception.mauvaisIdException;

public class Pioche extends Capacite {
    int nbpioche;

    public Pioche(int nb){
        super("Effet pioche");
        if (nb==0) {nb=1;}
        this.setNbpioche(nb);
    }

    public int getNbpioche() {
        return nbpioche;
    }

    public void setNbpioche(int nbpioche) {
        this.nbpioche = nbpioche;
    }

    @Override
    public void realiser(Carte lanceur, Plateau pPlateau, int pIdLanceur) {
        int i;
        for(i=0;i<this.nbpioche-1;i++){
            try {
                pPlateau.pioche(pPlateau.joueurActuel(pIdLanceur));
                }catch(mauvaisIdException e){} //TODO
            }
    }
}
