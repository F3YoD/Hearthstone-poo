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
    public Hero(String pNom, int pVies, Pouvoir pPouvoir){
        this.setNom(pNom);
        this.setVies(pVies);
        this.pouvoir = pPouvoir;
    }
    public Hero(String pNom, int pVies, String pNomPouvoir){
        this.setNom(pNom);
        this.setVies(pVies);
    }

    // ================================================================== \\
    // =========================== GETS/SETS ============================ \\
    // ================================================================== \\
    public String getNom(){return this.nom;}
    public int getVies(){return this.vies;}
    public Pouvoir getPouvoir(){return this.pouvoir;}

    private void setNom(String pNom){
        if(pNom.trim().equals(""))
            throw new IllegalArgumentException();

        this.nom = pNom;
    }

    private void setVies(int pVies){
        if(pVies < 0)
            throw new IllegalArgumentException();

        this.vies = pVies;
    }

    public void addVies(int pVies){
        this.vies += pVies;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String toString(){
        return "Hero["+this.getNom()+" , pv : " + this.getVies() +" ]";
    }
}
