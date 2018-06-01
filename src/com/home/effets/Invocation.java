package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.carte.Serviteur;

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
    public void realiser(Carte lanceur, Plateau pPlateau) {
        int i;
        Serviteur invocation = new Serviteur(this.getNomcarte(),1,this.getVie(),this.getAttaque());
        invocation.setPriorite(this.provo);
        for(i=0;i<this.nbinvocation;i++) {
                pPlateau.joueurActuel().getTerrain().ajouterCarte(invocation);
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
