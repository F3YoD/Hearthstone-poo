package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.exception.noCarteException;

import java.util.Scanner;

public class MarqueDuChasseur extends Capacite {

    public MarqueDuChasseur(){
        super("Marque du chasseur");
    }

    @Override
    public void realiser(Carte lanceur, Plateau pPlateau) {
        Scanner sc = new Scanner(System.in);
        System.out.println("A quel serviteur voulez vous reduire les pv a 1 ?  \n ");
        String cherche =sc.nextLine();
        try{
            pPlateau.joueurAAttaquer().getTerrain().Findwithname(cherche).setVies(1);
        }catch (noCarteException e){
            System.out.println("La carte n'est pas présente en face");
            this.realiser(lanceur,pPlateau);
        }
    }

}

