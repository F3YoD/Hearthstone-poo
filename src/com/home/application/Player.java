package com.home.application;

import com.home.carte.Main;

public class Player {
    private int vies;
    private Main main;

    public Player(int pV, Main pMain){
        this.vies = pV;
        this.main = pMain;
    }

    public String toString(){
        return "PV : " + this.vies + "\n";
    }
}
