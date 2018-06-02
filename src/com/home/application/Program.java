package com.home.application;

import com.home.Environement.Deck;
import com.home.Environement.Main;
import com.home.Environement.Plateau;
import com.home.Environement.Terrain;
import com.home.carte.*;
import com.home.effets.*;
import com.home.exception.*;
import com.home.personnage.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String argv[]) {
        game();
    }

    private static void InitDeckRexar(Deck pDeck){
        Serviteur c1 = new Serviteur("Chasse-marree murloc", 2, 1, 2, new Invocation("murloc", 1, 1, 1,0));
        Sort c2 = new Sort("Charge", 1,new Charge());
        Sort c3 = new Sort("Attaque Mentale",2,new AttaqueMentale(5));
        Serviteur c4 = new Serviteur("Champion de hurlevent",7,6,6,
                new CapaciteBonus("Bonus de Hurlevent",1,1));
        Serviteur c5 = new Serviteur("Chef de raid",3,2,2, new CapaciteBonus("Bonus du chef de guerre",1,0));
        Serviteur c6 = new Serviteur("Garde de Baie-du-butin",5,4,5,new Provocation());
        Serviteur c7 = new Serviteur("La missiliere temeraire",6,2,5,new Charge());
        Serviteur c8 = new Serviteur("L'ogre-magi",4,4,4,new Provocation());
        Serviteur c9 = new Serviteur("Archimage",6,7,4,new Provocation());
        Serviteur c10 = new Serviteur("Gnome lepreux", 1,1,1,new AttaqueMentale(2));
        Serviteur c11 = new Serviteur("Golem des moissons", 3,3,2,new Invocation("Golem endomage",1,2,1,0));

        // carte specifique a Rexar
        Serviteur c12 = new Serviteur("Busard affame",5,2,3,new Pioche(1));
        Sort c13 = new Sort("Marque du chasseur", 1,new MarqueDuChasseur());
        Sort c14 = new Sort("Tir des arcanes", 1,new AttaqueMentale(2));
        Sort c15 = new Sort("Lachez les chiens",3,new Invocation("chien",1,1,3,0));
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

    private static void InitDeckJaina(Deck pDeck){
        Serviteur c1 = new Serviteur("Chasse-marree murloc", 2, 1, 2, new Invocation("Murloc", 1, 1, 1,0));
        Sort c2 = new Sort("Charge", 1,new Charge());
        Sort c3 = new Sort("Attaque Mentale",2,new AttaqueMentale(5));
        Serviteur c4 = new Serviteur("Champion de hurlevent",7,6,6,
                new CapaciteBonus("Bonus de Hurlevent",1,1));
        Serviteur c5 = new Serviteur("Chef de raid",3,2,2, new CapaciteBonus("Bonus du chef de guerre",1,0));
        Serviteur c6 = new Serviteur("Garde de Baie-du-butin",5,4,5,new Provocation());
        Serviteur c7 = new Serviteur("La missiliere temeraire",6,2,5,new Charge());
        Serviteur c8 = new Serviteur("L'ogre-magi",4,4,4,new Provocation());
        Serviteur c9 = new Serviteur("Archimage",6,7,4,new Provocation());
        Serviteur c10 = new Serviteur("Gnome lepreux", 1,1,1,new AttaqueMentale(2));
        Serviteur c11 = new Serviteur("Golem des moissons", 3,3,2,new Invocation("Golem endomage",1,2,1,0));

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
        //Serviteur c3= new Serviteur("Gnome lepreux",1,1,1,new AttaqueMentale(5));
        //c3.getCapacite().realiser(c3,p);
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

    private static void game (){
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


        while(jeu){
            System.out.println("Tour :" + plateau.joueurActuel().getHero().getNom() + "\n");
            try {
                plateau.joueurActuel().getHero().addManaMax(1);
            }catch (maxManaException e){
                //on ajoute pas de mana
                System.out.println("Mana max \n");
            }
            //on mets les memes valeurs au mana max et au mana du joueur qui joue
            plateau.joueurActuel().getHero().setMana(plateau.joueurActuel().getHero().getManamax());
            plateau.pioche(plateau.joueurActuel());
            //On rends de nouveau dispo la capacité du héros
            plateau.joueurActuel().getHero().setPouvoirdispo(true);
            dessiner(plateau);
            plateau.joueurActuel().getMain().dessinerMain();
            //On dit que chaque carte sur le terrain au tour precedent peut maintenant attaquer
            for (Serviteur s: plateau.joueurActuel().getTerrain().getLstCarte()){
                s.setAttente(0);
            }
            int joueuractuel=plateau.getIdJoueurActuel();
            while(joueuractuel == plateau.getIdJoueurActuel()){
                Scanner sc=new Scanner(System.in);
                tour(plateau,sc);
                dessiner(plateau);
            }
        }


        }
    /**
     * le sous programme demande au joueur ce qu'il veut faire que le joueur veut faire
     * @return
     */
    private static int getChoix(){
        Scanner sc2 = new Scanner(System.in);
        int choix;
        do{
            System.out.println("************************************faite un choix :");
            System.out.println("1) posez 1 carte (taper 1)");
            System.out.println("2) attaquez avec une carte (taper 2)");
            System.out.println("3) utiliser la capacitée du héro (taper 3)");
            System.out.println("4) passez le tour (taper 4)");
            try {
                choix = sc2.nextInt();
            }catch (InputMismatchException e){
                choix =5;
                sc2=new Scanner(System.in);
                System.out.println("\n");
            }
            if(choix < 1 || choix > 4)
                System.out.println("erreure de saisie, recommancer");

        }while(choix < 1 || choix > 4);

        return choix;
    }

    private static void tour(Plateau p,Scanner sc){
        int choix =getChoix();
        if (choix == 1){
            System.out.println("Qui voulez vous jouer ? (tapez le nom de la carte en entier)\n");
            String cherche =sc.nextLine();
            try {
                Carte c = p.joueurActuel().getMain().Findwithname(cherche.trim());
                c.lancer(p);
            }catch (noCarteException e){
                System.out.println("Cette carte n'est pas présente \n");
            }catch (lowManaException e1){
                System.out.println("Vous n'avez pas assez de mana \n");
            }catch (provocationException e2){
                System.out.println("Impossible de lancer d'attaquer car une carte en face provoque");
            }
        }else if(choix==2){
            System.out.println("Avec qui voulez vous attaquer ? (Tapez le nom de la carte en entier ou tapez hero pour attaquer le héro adverse) \n");
            String cherche =sc.nextLine();
            System.out.println("Qui voulez vous attaquer ? \n");
            String cherche2=sc.nextLine();
            if (cherche2.trim().equals("hero")){
               try {
                   Serviteur s = p.joueurActuel().getTerrain().Findwithname(cherche.trim());
                   s.attaquehero(p);
               }catch (noCarteException e) {
                   System.out.println("Ce serviteur n'est pas sur le terrain \n");
               }catch (provocationException e1){
                   System.out.println("Un serviteur provoque en face , impossible d'attaquer\n");
               }catch (attenteException e2){
                   System.out.println("Ce serviteur doit arrente un tour avant de pourvoir attaquer \n");
               }
            }
            else{
                try {
                    Serviteur s = p.joueurActuel().getTerrain().Findwithname(cherche.trim());
                    Serviteur cible = p.joueurAAttaquer().getTerrain().Findwithname(cherche2.trim());
                    s.attaque(p, cible);
                } catch (noCarteException e) {
                    System.out.println("Un des deux ou les deux serviteurs ne sont pas sur le terrain \n");
                } catch (provocationException e1) {
                    System.out.println("Impossible d'attaquer car une carte a provocation en face");
                } catch (attenteException e2) {
                    System.out.println("Impossible d'attaquer car cette carte doit attendre un tour pour etre prete");
                }
            }
        }else if(choix==3){
            try{
                p.joueurActuel().getHero().getPouvoir().lancer(p);
            }catch (noLifeException e){
                System.out.println(p.joueurActuel().getHero().getNom() +"a gagné");
                System.exit(0);
            }catch (pouvoirUtiliseException e1){
                System.out.println("Pouvoir deja utilisé \n");
            }
        }else if(choix==4){
            p.changementJoueur();
        }
    }

    private static void dessiner(Plateau p){
        //On dessine les pv
        System.out.println("PV rexar : " + p.getJoueur1().getHero().getVies()+ "       "+"PV Jaine : " + p.getJoueur2().getHero().getVies()+"\n") ;
        System.out.println("Votre mana :" + p.joueurActuel().getHero().getMana() +"/" + p.joueurActuel().getHero().getManamax());
        //On dessine le terrain ennemi
        System.out.println("Terrain ennemie :\n");
        System.out.println(p.joueurAAttaquer().getTerrain().dessinerTerrain());
        //On dessine le terrain du joueur
        System.out.println("Votre terrain :\n");
        System.out.println(p.joueurActuel().getTerrain().dessinerTerrain());
        //on dessine notre main
        System.out.println("Votre Main :"+"\n");
        System.out.println(p.joueurActuel().getMain().dessinerMain());
    }
}





