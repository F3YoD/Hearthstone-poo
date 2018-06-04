package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Serviteur;
import com.home.exception.*;
import com.home.personnage.Hero;

import java.util.Scanner;

/**
 * <b>Feu hérite de Pouvoir et est un Pouvoir Particulier</b>
 * <p>
 * lorque le héro utilise son pouvoir il cause 1 degat de feu
 * au hero adverse/serviteur adverse
 * </p>
 * @author yoann/pierre
 */
public class Feu implements Pouvoir{
    public Feu(){
        System.out.println("ceration du pouvoir");
    }

    // ================================================================== \\
    // =========================== OVERRIDES ============================ \\
    // ================================================================== \\
    @Override
    public void lancer(Plateau plat) throws noLifeException, pouvoirUtiliseException,noCarteException,provocationException {
        if (!plat.joueurActuel().getHero().isPouvoirdispo()){
            throw new pouvoirUtiliseException("Pouvoir deja utilisé");
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Qui voulez vous attaquer avec votre boule de feu ? (Si vous voulez attaquer le Héro adverse marquez hero sinon le nom de la carte) \n ");
        String cherche =sc.nextLine();
        if (cherche.trim().equals("hero")) {
            try {
                if(plat.joueurAAttaquer().getTerrain().provocation()){
                    throw new provocationException("Une carte en face est en train de provoquer , impossible d'attaquer \n");
                }
                plat.joueurAAttaquer().getHero().prendDegats(1);
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
                cible.prendDamage(1);
            }catch (noLifeException e1){
                try{
                    plat.joueurAAttaquer().getTerrain().getLstCarte().remove(plat.joueurAAttaquer().getTerrain().Findwithname(cherche.trim()));
                }catch (noCarteException e2){}
            }
        }
        plat.joueurActuel().getHero().setPouvoirdispo(false);
    }
}