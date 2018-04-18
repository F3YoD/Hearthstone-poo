package com.home.personnage;

import com.home.effets.Pouvoir;

public class Hero {
    // ================================================================== \\
    // =========================== ATTRIBUTS ============================ \\
    // ================================================================== \\
    private String nom;
    private int vies;
    private Pouvoir pouvoir;

    // ================================================================== \\
    // =========================== CONSTRUCT ============================ \\
    // ================================================================== \\
    public Hero(String nom, int vies, Pouvoir pPouvoir){

    }
    public Hero(String nom, int vies, String pNomPouvoir){

    }

    // ================================================================== \\
    // =========================== GETS/SETS ============================ \\
    // ================================================================== \\
    public String getNom(){return this.nom;}
    public int getVies(){return this.vies;}
    public Pouvoir getPouvoir(){return this.pouvoir;}

    public void setNom(String pNom){
        if(pNom.trim().equals(""))
            throw new IllegalArgumentException();

        this.nom = pNom;
    }
}
