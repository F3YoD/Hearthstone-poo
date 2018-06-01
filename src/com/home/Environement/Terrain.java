package com.home.Environement;

import com.home.carte.Carte;
import com.home.carte.Serviteur;

import java.util.ArrayList;

public class Terrain {
    private ArrayList<Serviteur> lstCarte;

    public Terrain(){
        this.lstCarte = new ArrayList<Serviteur>();
    }
    public Terrain (ArrayList<Serviteur> pListe){
        this.setLstCarte(pListe);
    }
    //getter/setter
    public void setLstCarte(ArrayList<Serviteur> liste){
        this.lstCarte=liste;
    }
    public ArrayList<Serviteur> getLstCarte(){
        return this.lstCarte;
    }

    //methodes

    public void ajouterCarte(Serviteur carte){
        this.lstCarte.add(carte);
    }
    public void supprimerCarte(Serviteur carte){ //todo a tester
        this.lstCarte.remove(carte);
    }
    public boolean estPrésente(Serviteur carte){
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
