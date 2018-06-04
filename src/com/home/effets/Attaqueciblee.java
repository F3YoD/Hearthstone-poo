package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.carte.Serviteur;
import com.home.exception.noCarteException;
import com.home.exception.noLifeException;
import com.home.exception.provocationException;

import java.util.Scanner;

/**
 * <b>Attaqueciblée hérite de Capacite et est une Capacite Particulière</b>
 * <p>
 * elle attaque une carte ou un hero ciblé
 * </p>
 * @author yoann/pierre
 */
public class Attaqueciblee extends Capacite {
    private int degats;
    private String nom;

    public Attaqueciblee(String nom,int degats){
        super("Attaque ciblée");
        this.setNom(nom);
        this.setDegats(degats);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public int getDegats() {
        return degats;
    }

    public String getNom() {
        return nom;
    }

    public void realiser(Carte lanceur, Plateau plat) throws provocationException,noCarteException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qui voulez vous attaquer ? (Si vous voulez attaquer le Héro adverse marquez hero sinon le nom de la carte) \n ");
        String cherche =sc.nextLine();
        if (cherche.trim().equals("hero")) {
            try {
                if(plat.joueurAAttaquer().getTerrain().provocation()){
                    throw new provocationException("Une carte en face est en train de provoquer , impossible d'attaquer \n");
                }
                plat.joueurAAttaquer().getHero().prendDegats(this.degats);
            }catch (noLifeException e){
                System.out.println(plat.joueurActuel().getHero().getNom()+ "gagne \n");
                System.exit(0);
            }
        }
        else{
            try{
                Serviteur cible = plat.joueurAAttaquer().getTerrain().Findwithname(cherche.trim());
                if ((cible.getPriorite()==0)&& (plat.joueurAAttaquer().getTerrain().provocation())){
                    throw new provocationException("Un personnage provoque en face");
                }
                cible.prendDamage(this.degats);
            }catch (noLifeException e1){
                try{
                    plat.joueurAAttaquer().getTerrain().getLstCarte().remove(plat.joueurAAttaquer().getTerrain().Findwithname(cherche.trim()));
                }catch (noCarteException e2){}
            }
        }

    }

}
