package com.home.Environement;


import com.home.personnage.Player;

import java.util.Objects;
import java.util.Random;

/**
 * <b>la class Plateau contient tout les éléments de la partie</b>
 * <p>
 * elle contient les deux joueurs et l'identifiant du joueur actuel
 * </p>
 * @author yoann/pierre
 */
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

    public Player joueurAAttaquer()  {
        if(this.getIdJoueurActuel()==1){
            return this.joueur2;
        }
        else if(this.getIdJoueurActuel()==2){
            return this.joueur1;
        }
        return null;
    }

    public Player joueurActuel()  {
        if(this.getIdJoueurActuel()==1){
            return this.joueur1;
        }
        else if(this.getIdJoueurActuel()==2){
            return this.joueur2;
        }
        return null;
    }

    /**
     *  pioche une carte aleatoirement dans la deck du joueur p
     *
     * @param p le joueur recevant la carte
     */
    public void pioche(Player p){
        if(!p.getDeck().getLstCarte().isEmpty()){
            Random rnd = new Random();
            int posCarte = rnd.nextInt(p.getDeck().getLstCarte().size());
            p.getMain().getListecarte().add(p.getDeck().getLstCarte().get(posCarte));
            p.getDeck().getLstCarte().remove(posCarte);
        }
        else{
            System.out.println("\033[31mLe deck est vide\033[0m");
        }
    }

    public void changementJoueur(){
        if (this.getIdJoueurActuel()==1){
            this.setIdJoueurActuel(2);
        }
        else{
            this.setIdJoueurActuel(1);
        }
    }

    @Override
    public String toString() {
        return "Plateau{" +
                "joueur1=" + joueur1 +
                ", joueur2=" + joueur2 +
                ", idJoueurActuel=" + idJoueurActuel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plateau)) return false;
        Plateau plateau = (Plateau) o;
        return getIdJoueurActuel() == plateau.getIdJoueurActuel() &&
                Objects.equals(getJoueur1(), plateau.getJoueur1()) &&
                Objects.equals(getJoueur2(), plateau.getJoueur2());
    }
}
