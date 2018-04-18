package com.home.carte;

import com.home.carte.Carte;

public class Serviteur extends Carte {
    // ================================================================== \\
    // =========================== ATTRIBUTS ============================ \\
    // ================================================================== \\
    private int nbVies;
    private int nbDegats;

    // ================================================================== \\
    // =========================== CONSTRUCT ============================ \\
    // ================================================================== \\
    public Serviteur(String pNom, int pCout, int pVies, int pDegats) throws IllegalArgumentException {
        super(pNom, pCout);
        this.setDegats(pDegats);
        this.setVies(pVies);
    }

    // ================================================================== \\
    // =========================== GETS/SETS ============================ \\
    // ================================================================== \\
    public int getVies(){return this.nbVies;}
    public int getDegats(){return this.nbDegats;}

    private void setVies(int pVie){
        if(pVie < 0)
            throw new IllegalArgumentException();

        this.nbVies = pVie;
    }

    private void setDegats(int pDegats){
        if(pDegats < 0)
            throw new IllegalArgumentException();

        this.nbDegats = pDegats;
    }

    // ================================================================== \\
    // ===========================  METHODES ============================ \\
    // ================================================================== \\
    public void addDegats(int pAjout){
        int res = this.getDegats() + pAjout;
        this.setDegats(res);
    }

    
}
