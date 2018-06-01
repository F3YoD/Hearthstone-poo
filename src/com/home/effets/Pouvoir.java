package com.home.effets;

import com.home.exception.noLifeException;
import com.home.personnage.Hero;

public interface Pouvoir {
    // ================================================================== \\
    // ===========================  METHODES ============================ \\
    // ================================================================== \\
    public void lancer(Hero pH) throws noLifeException;
}