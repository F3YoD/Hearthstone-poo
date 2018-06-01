package com.home.personnage;

import com.home.effets.Pouvoir;

public class Hero {

    // ================================================================== \\
    // =========================== ATTRIBUTS ============================ \\
    // ================================================================== \\
    private int vies;
    private Pouvoir pouvoir;
    private int mana;
    private String nom;
    // ================================================================== \\
    // =========================== CONSTRUCT ============================ \\
    // ================================================================== \\
    public Hero(String pNom, int pVies, Pouvoir pPouvoir){
        this.setNom(pNom);
        this.setVies(pVies);
        this.setPouvoir(pPouvoir);
        this.mana=0;
    }

    // ================================================================== \\
    // =========================== GETS/SETS ============================ \\
    // ================================================================== \\
    public String getNom(){return this.nom;}
    public int getVies(){return this.vies;}
    public Pouvoir getPouvoir(){return this.pouvoir;}


    public int getMana() {
        return mana;
    }

    public void setPouvoir(Pouvoir pouvoir) {
        this.pouvoir = pouvoir;
    }

    public void setNom(String pNom){
        if(pNom.trim().equals(""))
            throw new IllegalArgumentException();

        this.nom = pNom;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setVies(int pVies){
        if(pVies < 0)
            throw new IllegalArgumentException();

        this.vies = pVies;
    }

    public void addVies(int pVies){
        this.vies += pVies;
    }

    public void addMana(int ajout){
        this.setMana(this.mana+ajout);
    }

    public void supprMana(int malus){
        this.setMana(this.mana-malus);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String toString(){
        return "Hero["+this.getNom()+" , pv : " + this.getVies() +" ]";
    }
}
