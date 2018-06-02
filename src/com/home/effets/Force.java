package com.home.effets;

import com.home.Environement.Plateau;
import com.home.exception.noLifeException;
import com.home.exception.pouvoirUtiliseException;
import com.home.personnage.Hero;

public class Force implements Pouvoir {

    public Force(){
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
        p.joueurAAttaquer().getHero().prendDegats(2);
        p.joueurActuel().getHero().setPouvoirdispo(false);
    }

}
