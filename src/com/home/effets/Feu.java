package com.home.effets;

import com.home.Environement.Plateau;
import com.home.exception.lowManaException;
import com.home.exception.noLifeException;
import com.home.exception.pouvoirUtiliseException;
import com.home.personnage.Hero;

public class Feu implements Pouvoir{
    public Feu(){
        System.out.println("ceration du pouvoir");
    }

    // ================================================================== \\
    // =========================== OVERRIDES ============================ \\
    // ================================================================== \\
    @Override
    public void lancer(Plateau p) throws noLifeException, pouvoirUtiliseException {
        if (!p.joueurActuel().getHero().isPouvoirdispo()){
            throw new pouvoirUtiliseException("Pouvoir deja utilisé");
        }
        p.joueurAAttaquer().getHero().prendDegats(1);
        p.joueurActuel().getHero().setPouvoirdispo(false);
    }
}