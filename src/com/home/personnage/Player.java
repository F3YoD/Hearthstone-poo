package com.home.personnage;

import com.home.carte.Main;

public class Player {
    // ================================================================== \\
    // =========================== ATTRIBUTS ============================ \\
    // ================================================================== \\
    private Main main;

    public Player(int pV, Main pMain){
        this.main = pMain;
    }

    public String toString(){
        return "PV : ???";
    }
}
