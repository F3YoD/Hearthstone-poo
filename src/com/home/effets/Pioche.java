package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;

/**
 * <b>Pioche hérite de Capacite et est une Capacite Particulière</b>
 * <p>
 * elle permet de piocher une carte dans le deck si celui ci n'est pas pas vide
 * </p>
 * @author yoann/pierre
 */
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
    public void realiser(Carte lanceur, Plateau pPlateau) {
        if(this.nbpioche > pPlateau.joueurActuel().getDeck().getLstCarte().size())
            System.out.println("pas assez de carte dans le deck");
        else{
            int i;
            for(i=0;i<this.nbpioche;i++){
                pPlateau.pioche(pPlateau.joueurActuel());
            }
        }
    }
}