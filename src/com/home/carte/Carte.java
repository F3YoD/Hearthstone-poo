package com.home.carte;

import com.home.effets.Capacite;

public class Carte {
    // ================================================================== \\
    // =========================== ATTRIBUTS ============================ \\
    // ================================================================== \\
    private String nom;
    private int cout;
    private Capacite capacite;
    // ================================================================== \\
    // =========================== CONSTRUCT ============================ \\
    // ================================================================== \\
    public Carte(String pNom, int pCout) {
            this.setNom(pNom);
            this.setCout(pCout);
    }

    // ================================================================== \\
    // =========================== GETS/SETS ============================ \\
    // ================================================================== \\
    public String getNom(){return this.nom;}
    public int getCout(){return this.cout;}

    public void setNom(String pNom) throws IllegalArgumentException {
        if(pNom.trim().equals(""))
            throw new IllegalArgumentException();

        this.nom = pNom;
    }

    public void setCout(int pCout) throws IllegalArgumentException {
        if(pCout < 0)
            throw new IllegalArgumentException();

        this.cout = pCout;
    }
    //tostring


    @Override
    public String toString() {
        return "nom : " + this.nom +" cout :" +this.cout;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}