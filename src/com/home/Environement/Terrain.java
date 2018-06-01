package com.home.Environement;

import com.home.carte.Carte;
import com.home.carte.Serviteur;
import com.home.exception.noCarteException;

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

    public ArrayList<Serviteur> Carteprioritaire(){
        ArrayList<Serviteur> liste = new ArrayList<Serviteur>();
        for (Serviteur s : lstCarte){
            if (s.getPriorite()==1){
                liste.add(s);
            }
        }
        return liste;
    }

    public boolean estPresente(String nom){
        for (Serviteur s : this.lstCarte){
            if (s.getNom()==nom){
                return true;
            }
        }
        return false;
    }

    public Serviteur Findwithname(String nom) throws noCarteException {
        Serviteur fin= new Serviteur();
        if (!this.estPresente(nom)){
            throw new noCarteException("Cette carte n'existe pas");
        }
        for(Serviteur s : this.lstCarte){
            if (s.getNom()==nom){
                return s;
            }
        }
        return fin;
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
