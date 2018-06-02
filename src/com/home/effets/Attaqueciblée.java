package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.carte.Serviteur;
import com.home.exception.noCarteException;
import com.home.exception.noLifeException;

import java.util.Scanner;

public class Attaqueciblée extends Capacite {
    private int degats;
    private String nom;

    public Attaqueciblée(String nom,int degats){
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

    public void realiser(Carte lanceur, Plateau plat){
        Scanner sc = new Scanner(System.in);
        System.out.println("Qui voulez vous attaquer ? (Si vous voulez attaquer le Héro adverse marquez hero sinon le nom de la carte) \n ");
        String cherche =sc.nextLine();
        if (cherche.trim().equals("hero")) {
            try {
                plat.joueurAAttaquer().getHero().prendDegats(this.degats);
            }catch (noLifeException e){
                System.out.println(plat.joueurActuel().getHero().getNom()+ "gagne \n");
                System.exit(0);
            }
        }
        else{
            try{
                Serviteur cible = plat.joueurAAttaquer().getTerrain().Findwithname(cherche.trim());
                cible.prendDamage(this.degats);
            }catch (noCarteException e) {
                System.out.println("La carte n'est pas présente en face");
                this.realiser(lanceur, plat);
            }catch (noLifeException e1){
                try{
                    plat.joueurAAttaquer().getTerrain().getLstCarte().remove(plat.joueurAAttaquer().getTerrain().Findwithname(cherche.trim()));
                }catch (noCarteException e2){}
            }
        }

    }

}
