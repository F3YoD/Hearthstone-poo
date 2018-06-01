package com.home.Environement;

import com.home.exception.mauvaisIdException;
import com.home.personnage.Player;

public class Plateau {
    private Player joueur1;
    private Player joueur2;
    private int idJoueurActuel;

    public Plateau(Player joueur1,Player joueur2){
        this.setJoueur1(joueur1);
        this.setJoueur2(joueur2);
        this.setIdJoueurActuel(1);
    }

    public Player getJoueur1() {
        return joueur1;
    }

    public Player getJoueur2() {
        return joueur2;
    }

    public int getIdJoueurActuel(){return this.idJoueurActuel;}

    public void setJoueur1(Player joueur1) {
        this.joueur1 = joueur1;
    }

    public void setJoueur2(Player joueur2) {
        this.joueur2 = joueur2;
    }

    public void setIdJoueurActuel(int pId){
        if(pId < 1 || pId > 2)
            throw new IllegalArgumentException();

        this.idJoueurActuel = pId;
    }

    public Player joueurAAttaquer(int pId) throws mauvaisIdException {
        if(pId==1){
            return this.joueur2;
        }
        else if(pId==2){
            return this.joueur1;
        }
        throw new mauvaisIdException("L'id est différent de 1 et 2");
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return "Joueur 1:" +this.joueur1.toString() +"\n Joueur 2:" +this.joueur2.toString();
    }
}
