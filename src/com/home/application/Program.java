package com.home.application;

import com.home.Environement.Deck;
import com.home.Environement.Main;
import com.home.Environement.Plateau;
import com.home.Environement.Terrain;
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
        //Init mains
        Main mainRexar = new Main();
        Main mainJaina = new Main();
        //Init Terrains
        Terrain terrainRexar=new Terrain();
        Terrain terrainJaina=new Terrain();
        // INIT CARTES
        Deck deckRexar = new Deck();
        Deck deckJaina = new Deck();
        InitDeckRexar(deckRexar);
        InitDeckJaina(deckJaina);
        //init players
        Player joueur1 = new Player(rexar,deckRexar,mainRexar,terrainRexar);
        Player joueur2 = new Player(jaina,deckJaina,mainJaina,terrainJaina);
        //init plateau
        Plateau plateau= new Plateau(joueur1,joueur2);

        joueur1.getHero().getPouvoir().lancer(joueur2.getHero());

        //System.out.println("" + plateau.toString());
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
