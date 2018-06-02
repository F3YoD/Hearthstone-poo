package com.home.effets;

import com.home.Environement.Plateau;
import com.home.carte.Carte;
import com.home.exception.provocationException;

public abstract class Capacite {
    public Capacite(String desc){
        this.setDescription(desc);
    }
    protected String description;

    public abstract void realiser(Carte lanceur, Plateau pPlateau) throws provocationException; // 0 = aucun 1 = j1 2 = j2
    public String getDescription(){
        return this.description;
    }
    public  void setDescription(String desc){
        this.description=desc;
    }

    @Override
    public String toString() {
        return "description" + this.description;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}