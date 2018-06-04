package com.home.effets;

import com.home.Environement.Plateau;
import com.home.exception.lowManaException;
import com.home.exception.noLifeException;
import com.home.exception.pouvoirUtiliseException;
import com.home.personnage.Hero;

/**
 * <b>l'interface Pouvoir est un atout que seul les heros possède</b>
 * <p>
 *
 * </p>
 * @author yoann/pierre
 */
public interface Pouvoir {
    // ================================================================== \\
    // ===========================  METHODES ============================ \\
    // ================================================================== \\
    public void lancer(Plateau p) throws noLifeException, pouvoirUtiliseException;
}