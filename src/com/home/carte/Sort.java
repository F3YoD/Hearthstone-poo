package com.home.carte;

import com.home.effets.*;

public class Sort extends Carte {

    private String nom;
    private Capacite capacite;

    public Sort(String pNom, int pCout, Capacite pCapacite){
        super(pNom, pCout);
        this.capacite = pCapacite;
    }


}
