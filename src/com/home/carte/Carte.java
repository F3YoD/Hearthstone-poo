package com.home.carte;

public class Carte {
    // ================================================================== \\
    // =========================== ATTRIBUTS ============================ \\
    // ================================================================== \\
    private String nom;
    private int cout;

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
}