package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.carte.Serviteur;
import com.home.exception.mauvaisIdException;

public class Invocation extends Capacite {
    private int nbinvocation;
    private String nomcarte;
    private int vie;
    private int attaque;
    private int provo;

    public Invocation(String nom,int pv,int degats,int nbinvo,int provo){
        super("Invocation");
        this.setVie(pv);
        this.setAttaque(degats);
        this.setNomcarte(nom);
        this.setProvo(provo);
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public void setNomcarte(String nomcarte) {
        this.nomcarte = nomcarte;
    }

    public void setProvo(int provo) {
        this.provo = provo;
    }

    public int getAttaque() {
        return attaque;
    }

    public int getProvo() {
        return provo;
    }

    public int getVie() {
        return vie;
    }

    public String getNomcarte() {
        return nomcarte;
    }

    @Override
    public void realiser(Carte lanceur, Plateau pPlateau, int pIdLanceur) {
        int i;
        Serviteur invocation = new Serviteur(this.getNomcarte(),0,this.getVie(),this.getAttaque());
        invocation.setPriorite(this.provo);
        for(i=0;i<this.nbinvocation;i++) {
            try {
                pPlateau.joueurActuel(pIdLanceur).getTerrain().ajouterCarte(invocation);
            } catch (mauvaisIdException e) {
            } //todo
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString() + "Invocation" + "nom carte" + this.nomcarte + "pv carte "+ this.vie + "degats carte" + this.attaque + "\n";
    }
}
