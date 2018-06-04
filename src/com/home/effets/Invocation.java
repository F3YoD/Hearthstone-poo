package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.carte.Serviteur;

import java.util.Objects;

/**
 * <b>Invocation hérite de Capacite et est une Capacite Particulière</b>
 * <p>
 * elle permet d'invoquer plusieurs cartes sur le terrain
 * </p>
 * @author yoann/pierre
 */
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
        this.setNbinvocation(nbinvo);
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

    public void setNbinvocation(int nbinvocation) {
        this.nbinvocation = nbinvocation;
    }

    public String getNomcarte() {
        return nomcarte;
    }

    @Override
    public void realiser(Carte lanceur, Plateau pPlateau) {
        int i;
        for(i=0;i<this.nbinvocation;i++) {
            Serviteur invocation = new Serviteur(this.getNomcarte(),1,this.getVie(),this.getAttaque());
            invocation.setCapacite(new Aucunecap());
            if (this.provo==1){
                invocation.setPriorite(1);
                invocation.getCapacite().setDescription("Provocation");
            }
            if (nbinvocation >1){
                    int j=i+1;
                    invocation.setNom(invocation.getNom()+" " + j);
            }
            pPlateau.joueurActuel().getTerrain().ajouterCarte(invocation);
        }
    }


    @Override
    public String toString() {
        return "Invocation{" +
                "nbinvocation=" + nbinvocation +
                ", nomcarte='" + nomcarte + '\'' +
                ", vie=" + vie +
                ", attaque=" + attaque +
                ", provo=" + provo +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invocation)) return false;
        if (!super.equals(o)) return false;
        Invocation that = (Invocation) o;
        return nbinvocation == that.nbinvocation &&
                getVie() == that.getVie() &&
                getAttaque() == that.getAttaque() &&
                getProvo() == that.getProvo() &&
                Objects.equals(getNomcarte(), that.getNomcarte());
    }

}
