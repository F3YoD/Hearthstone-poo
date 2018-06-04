package com.home.carte;

import com.home.Environement.Plateau;
import com.home.effets.Capacite;
import com.home.exception.*;

import java.util.Objects;

/**
 * <b>Serviteur hérite de Carte et est une Carte Particulière</b>
 * @author yoann/pierre
 */
public class Serviteur extends Carte {
    // ================================================================== \\
    // =========================== ATTRIBUTS ============================ \\
    // ================================================================== \\
    private int nbVies;
    private int nbDegats;
    private int priorite;
    private int attente;

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
        super(pNom, pCout,cap);
        this.setDegats(pDegats);
        this.setVies(pVies);
        this.setPriorite(0);
        this.setAttente(1);
    }
    public Serviteur(){};

    // ================================================================== \\
    // =========================== GETS/SETS ============================ \\
    // ================================================================== \\
    public int getVies(){return this.nbVies;}
    public int getDegats(){return this.nbDegats;}
    public int getPriorite(){return this.priorite;}
    public int getAttente(){return this.attente;}



    public void setVies(int pVie){
        if(pVie < 0)
            throw new IllegalArgumentException();

        this.nbVies = pVie;
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
     public void prendDamage(int degats)throws noLifeException {
        this.nbVies=this.nbVies -degats;
        if (this.nbVies<1){
            throw new noLifeException("Ce serviteur est mort");
        }
     }

     public void attaquehero(Plateau p)throws provocationException, attenteException {
         if(this.attente>0){
             throw new attenteException("Ne peut pas attaquer ce tour ci");
         }

        if(p.joueurAAttaquer().getTerrain().provocation()){
            throw new provocationException("Un serviteur provoque");
        }
        try{
            p.joueurAAttaquer().getHero().prendDegats(this.nbDegats);
            this.setAttente(1);
        }catch (noLifeException e){
            System.out.println(p.joueurActuel().getHero().getNom()+"gagne \n");
            System.exit(0);
        }
     }


    public void attaque(Plateau p,Serviteur cible) throws attenteException, provocationException {
        if(this.attente>0){
            throw new attenteException("Ne peut pas attaquer ce tour ci");
        }
        if(cible.getPriorite()!=1 && p.joueurAAttaquer().getTerrain().provocation()){
            throw new provocationException("Il y a une carte qui provoque");
        }

        try {
            cible.prendDamage(this.nbDegats);
            this.setAttente(1);
        }catch (noLifeException e){
            p.joueurAAttaquer().getTerrain().getLstCarte().remove(cible);
        }
        try {
            this.prendDamage(cible.nbDegats);
        }catch (noLifeException e1){
            p.joueurActuel().getTerrain().getLstCarte().remove(this);
        }
    }

    public void addVies(int pAjout){
        int res = this.getVies() + pAjout;
        this.setVies(res);
    }

    @Override
    public String dessinerMidCarte4(){
        String fin = "|                \033[31mpv:"+ this.nbVies ;
        while (fin.length()<29+5+8){
            fin += " ";
        }
        fin += "\033[0m|";
        return fin;
    }

    @Override
    public String dessinerMidCarte5(){
        String fin = "|               deg:"+ this.nbDegats;
        while (fin.length()<29+8){
            fin += " ";
        }
        fin +="|";
        return fin;
    }


    public void lancer(Plateau plateau) throws lowManaException, provocationException, noCarteException {

        if (this.getCout() > plateau.joueurActuel().getHero().getMana()) {
            throw new lowManaException("Pas assez de mana");
        }
        //suppression du mana
        plateau.joueurActuel().getHero().supprMana(this.getCout());
        //ajout de la carte au terrain
        plateau.joueurActuel().getTerrain().ajouterCarte(this);
        //on effectue la capacitée de la carte
        this.getCapacite().realiser(this, plateau);
        //suppression de la carte de la main
        plateau.joueurActuel().getMain().supprimerCarte(this);


    }

    @Override
    public String toString() {
        return super.toString() +
                "Serviteur{" +
                "nbVies=" + nbVies +
                ", nbDegats=" + nbDegats +
                ", priorite=" + priorite +
                ", attente=" + attente +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Serviteur)) return false;
        if (!super.equals(o)) return false;
        Serviteur serviteur = (Serviteur) o;
        return nbVies == serviteur.nbVies &&
                nbDegats == serviteur.nbDegats &&
                getPriorite() == serviteur.getPriorite() &&
                getAttente() == serviteur.getAttente();
    }

}
