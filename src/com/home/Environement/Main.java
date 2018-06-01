package com.home.Environement;

import com.home.carte.Carte;

import java.util.ArrayList;

public class Main {
    private int nb_carte; //nombre de carte actuellement dans la main;
    private ArrayList<Carte> liste_carte;

    //constructeur
    public Main(){
        this.nb_carte=0;
        this.liste_carte=new ArrayList<Carte>();
    }

    //setter
    public void setNbcartes(int nombre){
        if (nombre > 0) {
            this.nb_carte = nombre;
        }
        else{
            System.err.println("le nombre de carte est inférieure a 1");
            System.exit(-1);
        }
    }


    //a faire : setteur qui permet de piocher aléatoirement une carte


    //getter

    public int getNbcartes(){
        return this.nb_carte;
    }

    public ArrayList<Carte> getListecarte(){
        return this.liste_carte;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        String fin="";
        for (Carte i : this.liste_carte){
            fin += i.toString() +"\n";
        }
        return fin;
    }

    public void supprimerCarte(Carte c){
        this.liste_carte.remove(c);
    }
}
