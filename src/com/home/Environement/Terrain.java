package com.home.Environement;

import com.home.carte.Carte;

import java.util.ArrayList;

public class Terrain {
    private ArrayList<Carte> lstCarte;

    public Terrain(){
        this.lstCarte = new ArrayList<Carte>();
    }
    public Terrain (ArrayList<Carte> liste){
        this.setLstCarte(liste);
    }
    //getter/setter
    public void setLstCarte(ArrayList<Carte> liste){
        this.lstCarte=liste;
    }
    public ArrayList<Carte> getLstCarte(){
        return this.lstCarte;
    }

    //methodes

    public void ajouterCarte(Carte carte){
        this.lstCarte.add(carte);
    }
    public void supprimerCarte(Carte carte){ //todo a tester
        this.lstCarte.remove(carte);
    }
    public boolean estPrésente(Carte carte){
        return this.lstCarte.contains(carte);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        String fin="";

        for (Carte i : this.lstCarte){
            fin += i.toString() +"\n";
        }


        return fin;
    }
}
