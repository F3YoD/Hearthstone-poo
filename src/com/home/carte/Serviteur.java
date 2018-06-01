package com.home.carte;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.effets.Capacite;
import com.home.exception.lowManaException;
import com.home.exception.mauvaisIdException;

public class Serviteur extends Carte {
    // ================================================================== \\
    // =========================== ATTRIBUTS ============================ \\
    // ================================================================== \\
    private int nbVies;
    private int nbDegats;
    private int priorite;
    private int attente;
    private Capacite capacite;

    // ================================================================== \\
    // =========================== CONSTRUCT ============================ \\
    // ================================================================== \\
    public Serviteur(String pNom, int pCout, int pVies, int pDegats) throws IllegalArgumentException {
        super(pNom, pCout);
        this.setDegats(pDegats);
        this.setVies(pVies);
        this.setPriorite(0);
        this.setAttente(1);
    }
    public Serviteur(String pNom, int pCout, int pVies, int pDegats,Capacite cap) throws IllegalArgumentException {
        super(pNom, pCout);
        this.setDegats(pDegats);
        this.setVies(pVies);
        this.setPriorite(0);
        this.setAttente(1);
        this.setCapacite(cap);
    }
    public Serviteur(){};

    // ================================================================== \\
    // =========================== GETS/SETS ============================ \\
    // ================================================================== \\
    public int getVies(){return this.nbVies;}
    public int getDegats(){return this.nbDegats;}
    public int getPriorite(){return this.priorite;}
    public int getAttente(){return this.attente;}

    public Capacite getCap() {
        return capacite;
    }

    public void setVies(int pVie){
        if(pVie < 0)
            throw new IllegalArgumentException();

        this.nbVies = pVie;
    }

    public void setCapacite(Capacite cap) {
        this.capacite = cap;
    }

    public void setDegats(int pDegats){
        if(pDegats < 0)
            throw new IllegalArgumentException();

        this.nbDegats = pDegats;
    }

    public void setPriorite(int prio){
        if(prio !=0 && prio != 1){
            throw new IllegalArgumentException();
        }
        this.priorite=prio;
    }

    public void setAttente(int attente){
        if (attente >1 ){
            throw new IllegalArgumentException();
        }
        this.attente=attente;
    }

    // ================================================================== \\
    // ===========================  METHODES ============================ \\
    // ================================================================== \\
    public void addDegats(int pAjout){
        int res = this.getDegats() + pAjout;
        this.setDegats(res);
    }

    public void addVies(int pAjout){
        int res = this.getVies() + pAjout;
        this.setVies(res);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    public void lancer(Plateau plateau) throws lowManaException{
        try {
            if (this.getCout() > plateau.joueurActuel(plateau.getIdJoueurActuel()).getHero().getMana()){
                throw new lowManaException("Pas assez de mana");
            }
            //suppression du mana
            plateau.joueurActuel(plateau.getIdJoueurActuel()).getHero().supprMana(this.getCout());
            //ajout de la carte au terrain
            plateau.joueurActuel(plateau.getIdJoueurActuel()).getTerrain().ajouterCarte(this);
            //on effectue la capacitée de la carte
            this.getCap().realiser(this,plateau,plateau.getIdJoueurActuel());
            //suppression de la carte de la main
            plateau.joueurActuel(plateau.getIdJoueurActuel()).getMain().supprimerCarte(this);
        }catch (mauvaisIdException e)  {} //TODO
    }
}
