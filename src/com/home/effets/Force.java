package com.home.effets;

import com.home.personnage.Hero;

public class Force implements Pouvoir {

    public Force(){
        System.out.println("ceration du pouvoir");
    }

    // ================================================================== \\
    // =========================== OVERRIDES ============================ \\
    // ================================================================== \\
    @Override
    public void lancer(Hero pH) {
        pH.addVies(-2);
    }

}
