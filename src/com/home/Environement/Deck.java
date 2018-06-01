package com.home.Environement;

import com.home.carte.Carte;

import java.util.ArrayList;

public class Deck {
    // ================================================================== \\
    // =========================== ATTRIBUTS ============================ \\
    // ================================================================== \\
    private ArrayList<Carte> lstCarte;

    public Deck(){
        this.lstCarte = new ArrayList<Carte>();
    }

    public boolean add(Carte pCarte){
        return this.lstCarte.add(pCarte);
    }

    public String toString(){
        String fin="";
        for (Carte i : this.lstCarte){
            fin += i.toString() +"\n";
        }
        return fin;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}