package com.home.application;

import com.home.carte.*;
import com.home.effets.*;
import com.home.personnage.*;

public class Program {

    public static void main(String argv[]){
        Pouvoir feu = new Feu();
        Pouvoir force = new Force();
        // INIT HERO
        Hero rexar = new Hero("rexar", 15, force);
        Hero jaina = new Hero("jaina", 15, feu);
        // INIT CARTES
        Deck deckRexar = new Deck();
        Deck deckJaina = new Deck();
        InitDeckRexar(deckRexar);
        InitDeckJaina(deckJaina);
        Player joueur1 = new Player(rexar,deckRexar);
        Player joueur2 = new Player(jaina,deckJaina);

        joueur1.getHero().getPouvoir().lancer(joueur2.getHero());

        System.out.println("" + joueur1.toString());
        System.out.println("" + joueur2.toString());
    }
    
    public static void InitDeckRexar(Deck pDeck){
        Serviteur c1 = new Serviteur("Chasse-marrée murloc", 2, 1, 2);
        Serviteur c2 = new Serviteur("Champion de hurlevent",7,6,6);

        pDeck.add(c1);
        pDeck.add(c2);
    }

    public static void InitDeckJaina(Deck pDeck){
        Serviteur c1 = new Serviteur("Chasse-marrée murloc", 2, 1, 2);
        Serviteur c2 = new Serviteur("Champion de hurlevent",7,6,6);

        pDeck.add(c1);
        pDeck.add(c2);
    }
}
