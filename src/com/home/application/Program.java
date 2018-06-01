package com.home.application;

import com.home.Environement.Deck;
import com.home.Environement.Main;
import com.home.Environement.Plateau;
import com.home.Environement.Terrain;
import com.home.carte.*;
import com.home.effets.*;
import com.home.exception.mauvaisIdException;
import com.home.personnage.*;

public class Program {

    public static void main(String argv[]) throws mauvaisIdException {
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

        startPartie(plateau);
    }
    
    public static void InitDeckRexar(Deck pDeck){
        Serviteur c1 = new Serviteur("Chasse-marrée murloc", 2, 1, 2, new Invocation("cri de guerre", 1, 1, 1));
        Sort c2 = new Sort("Charge", 1,new Charge());
        Sort c3 = new Sort("Attaque Mentale",2,new AttaqueMentale(5));
        Serviteur c4 = new Serviteur("Champion de hurlevent",7,6,6,
                new CapaciteBonus("Bonus de Hurlevent",1,1));
        Serviteur c5 = new Serviteur("Chef de raid",3,2,2, new CapaciteBonus("Bonus du chef de guerre",1,0));
        Serviteur c6 = new Serviteur("Garde de Baie-du-butin",5,4,5,new Provocation());
        Serviteur c7 = new Serviteur("La missilière téméraire",6,2,5,new Charge());
        Serviteur c8 = new Serviteur("L'ogre-magi",4,4,4,new Provocation());
        Serviteur c9 = new Serviteur("Archimage",6,7,4,new Provocation());
        Serviteur c10 = new Serviteur("Gnôme lépreux", 1,1,1,new AttaqueMentale(2));
        Serviteur c11 = new Serviteur("Golem des moissons", 3,3,2,new Invocation("Golemisation",1,2,1));

        pDeck.add(c1);
        pDeck.add(c2);
        pDeck.add(c3);
        pDeck.add(c4);
        pDeck.add(c5);
        pDeck.add(c6);

    }

    public static void InitDeckJaina(Deck pDeck){
        Serviteur c1 = new Serviteur("Chasse-marrée murloc", 2, 1, 2, new Invocation("cri de guerre", 1, 1, 1));
        Sort c2 = new Sort("Charge", 1,new Charge());
        Serviteur c3 = new Serviteur("Champion de hurlevent",7,6,6);
        Serviteur c4= new Serviteur("Gnome lepreux",1,1,1,new Attaqueciblée("Attaque du lepreux",2));

        pDeck.add(c1);
        pDeck.add(c2);
        pDeck.add(c3);
    }

    public static void startPartie(Plateau p) throws mauvaisIdException {
        System.out.println("******************************************* DEBUT PARTIE");
        System.out.println(p.getJoueur1().getHero().toString());
        Serviteur c3= new Serviteur("Gnome lepreux",1,1,1,new AttaqueMentale(5));
        c3.getCap().realiser(c3,p,2);
        System.out.println(p.getJoueur1().getHero().toString());
        System.out.println("\033[31m******************************************* FIN PARTIE\033[0m");
    }
}
