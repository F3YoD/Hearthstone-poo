package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.exception.noCarteException;

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
        if (cherche.trim().equals("hero")){
                 plat.joueurAAttaquer().getHero().addVies(-this.degats);
        }
        else{
            try{
                plat.joueurAAttaquer().getTerrain().Findwithname(cherche).addVies(-this.degats);
            }catch (noCarteException e) {
                System.out.println("La carte n'est pas présente en face");
                this.realiser(lanceur, plat);
            }
        }

    }

}
