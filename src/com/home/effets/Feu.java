package com.home.effets;

import com.home.personnage.Hero;

public class Feu implements Pouvoir{
    public Feu(){
        System.out.println("ceration du pouvoir");
    }

    // ================================================================== \\
    // =========================== OVERRIDES ============================ \\
    // ================================================================== \\
    @Override
    public void lancer(Hero pH) {
        pH.addVies(-1);
    }
}