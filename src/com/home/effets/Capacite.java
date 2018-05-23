package com.home.effets;

import com.home.carte.Serviteur;

import java.util.ArrayList;

public abstract class Capacite {
    public Capacite(){

    }
    protected String description;
    protected String type;
    public abstract void realiser(Serviteur serviteur, ArrayList<Serviteur> lst); //Todo check les parametres
    public abstract String getDescription();
    public abstract void setDescription(String desc);
    public abstract String toString();
    public abstract boolean equals();
}