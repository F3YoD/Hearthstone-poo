package com.home.Environement;

import com.home.personnage.Player;

public class Plateau {
    private Player joueur1;
    private Player joueur2;

    public Plateau(Player joueur1,Player joueur2){
        this.setJoueur1(joueur1);
        this.setJoueur2(joueur2);
    }

    public Player getJoueur1() {
        return joueur1;
    }

    public Player getJoueur2() {
        return joueur2;
    }

    public void setJoueur1(Player joueur1) {
        this.joueur1 = joueur1;
    }

    public void setJoueur2(Player joueur2) {
        this.joueur2 = joueur2;
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
