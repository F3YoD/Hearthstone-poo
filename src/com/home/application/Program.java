package com.home.application;

import com.home.Environement.Deck;
import com.home.Environement.Main;
import com.home.Environement.Plateau;
import com.home.Environement.Terrain;
import com.home.carte.*;
import com.home.effets.*;
import com.home.exception.maxManaException;
import com.home.personnage.*;

public class Program {

    public static void main(String argv[]) {
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
        Serviteur c1 = new Serviteur("Chasse-marrée murloc", 2, 1, 2, new Invocation("cri de guerre", 1, 1, 1,0));
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
        Serviteur c11 = new Serviteur("Golem des moissons", 3,3,2,new Invocation("Golem endomagé",1,2,1,0));

        // carte specifique a Rexar
        Serviteur c12 = new Serviteur("Busard affamé",5,2,3,new Pioche(1));
        Sort c13 = new Sort("Marque du chasseur", 1,new MarqueDuChasseur());
        Sort c14 = new Sort("Tir des arcanes", 1,new AttaqueMentale(2));
        Sort c15 = new Sort("Lâchez les chiens",3,new Invocation("Lâchez les chiens",1,1,3,0));
        Sort c16 = new Sort("Ordre de tuer",3,new Attaqueciblée("Ordre de tuer", 3));

        pDeck.add( c1);
        pDeck.add( c2);
        pDeck.add( c3);
        pDeck.add( c4);
        pDeck.add( c5);
        pDeck.add( c6);
        pDeck.add( c7);
        pDeck.add( c8);
        pDeck.add( c9);
        pDeck.add(c10);
        pDeck.add(c11);
        pDeck.add(c12);
        pDeck.add(c13);
        pDeck.add(c14);
        pDeck.add(c15);
        pDeck.add(c16);

    }

    public static void InitDeckJaina(Deck pDeck){
        Serviteur c1 = new Serviteur("Chasse-marrée murloc", 2, 1, 2, new Invocation("Murloc", 1, 1, 1,0));
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
        Serviteur c11 = new Serviteur("Golem des moissons", 3,3,2,new Invocation("Golem endomagé",1,2,1,0));

        // carte specifique a Jaina
        Sort c12 = new Sort("Choc de flamme",7,new CapaciteDegatMassive(4));
        Sort c13 = new Sort("Eclair de givre", 2, new Attaqueciblée("Attaque du givre",3));
        Sort c14 = new Sort("Intelligence des arcanes", 2,new Pioche(2));
        Sort c15 = new Sort("Image mirroir", 1, new Invocation("Image Mirroir", 2,0,2,1));
        Sort c16 = new Sort("Explosion pyrotechnique", 10,new Attaqueciblée("Explosion pyrotechnique",10));

        pDeck.add( c1);
        pDeck.add( c2);
        pDeck.add( c3);
        pDeck.add( c4);
        pDeck.add( c5);
        pDeck.add( c6);
        pDeck.add( c7);
        pDeck.add( c8);
        pDeck.add( c9);
        pDeck.add(c10);
        pDeck.add(c11);
        pDeck.add(c12);
        pDeck.add(c13);
        pDeck.add(c14);
        pDeck.add(c15);
        pDeck.add(c16);
    }

    public static void startPartie(Plateau p)  {
        System.out.println("******************************************* DEBUT PARTIE");
        System.out.println(p.getJoueur1().getHero().toString());
        Serviteur c3= new Serviteur("Gnome lepreux",1,1,1,new AttaqueMentale(5));
        c3.getCapacite().realiser(c3,p);
        System.out.println(p.getJoueur1().getHero().toString());
        System.out.println("\033[32m******************************************* FIN PARTIE\033[0m");

        Main m = new Main();
        m.getListecarte().add(p.getJoueur1().getDeck().getLstCarte().get(5));
        m.getListecarte().add(p.getJoueur1().getDeck().getLstCarte().get(6));
        m.getListecarte().add(p.getJoueur1().getDeck().getLstCarte().get(7));
        m.getListecarte().add(p.getJoueur1().getDeck().getLstCarte().get(8));
        m.getListecarte().add(p.getJoueur1().getDeck().getLstCarte().get(9));
        m.getListecarte().add(p.getJoueur1().getDeck().getLstCarte().get(9));
        m.getListecarte().add(p.getJoueur1().getDeck().getLstCarte().get(9));
        m.getListecarte().add(p.getJoueur1().getDeck().getLstCarte().get(9));
        m.getListecarte().add(p.getJoueur1().getDeck().getLstCarte().get(9));
        m.getListecarte().add(p.getJoueur1().getDeck().getLstCarte().get(9));
        m.getListecarte().add(p.getJoueur1().getDeck().getLstCarte().get(9));
        m.getListecarte().add(p.getJoueur1().getDeck().getLstCarte().get(9));
        System.out.println(m.dessinerMain());

    }

    public static void jeu (){
        Pouvoir feu = new Feu();
        Pouvoir force = new Force();
        boolean jeu=true;

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

        while(jeu){
            System.out.println("Tour : Rexar:");
            try {
                plateau.joueurActuel().getHero().addManaMax(1);
            }catch (maxManaException e){
            }
            //on mets les memes valeurs au mana max et au mana du joueur qui joue
            plateau.joueurActuel().getHero().setMana(plateau.joueurActuel().getHero().getManamax());
            plateau.pioche(plateau.joueurActuel());
            //todo dessiner le terrain ennemie
            //todo dessiner le terrain allier
            //dessin de la main
            plateau.joueurActuel().getMain().dessinerMain();
            //fonction get


        }
    }
}


