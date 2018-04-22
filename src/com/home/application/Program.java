package com.home.application;

import com.home.carte.*;
import com.home.personnage.*;

public class Program {

    public static void main(String argv[]){
        // INIT HERO
        Hero rexar = new Hero("rexar", 15, "force");
        Hero jaina = new Hero("jaina", 15, "feu");
        // INIT CARTES
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        InitDeck(deck1);
        Player joueur1 = new Player(rexar);
        Player joueur2 = new Player(jaina);

        System.out.println("" + joueur1.toString());
        System.out.println("" + joueur2.toString());
        System.out.println("" + deck1.toString());
    }
    
    public static void InitDeck(Deck pDeck){
        Serviteur c1 = new Serviteur("Chasse-marrée murloc", 2, 1, 2);
        Serviteur c2 = new Serviteur("Champion de hurlevent",7,6,6);

        pDeck.add(c1);
        pDeck.add(c2);
    }
}
