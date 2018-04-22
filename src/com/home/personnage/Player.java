package com.home.personnage;

import com.home.carte.*;

public class Player {
    // ================================================================== \\
    // =========================== ATTRIBUTS ============================ \\
    // ================================================================== \\
    private Deck deck;
    private Hero hero;

    // ================================================================== \\
    // =========================== CONSTRUCT ============================ \\
    // ================================================================== \\
    public Player(Hero pHero, Deck deck){
        this.setDeck(deck);
        this.setHero(pHero);
    }

    // ================================================================== \\
    // =========================== GETS/SETS ============================ \\
    // ================================================================== \\
    public Deck getDeck(){return this.deck;}
    public Hero getHero(){return this.hero;}

    public void setDeck(Deck deck){
        this.deck = deck;
    }

    public void setHero(Hero pHero){
        if(!pHero.getNom().equals("rexar") && !pHero.getNom().equals("jaina"))
            throw new IllegalArgumentException();

        this.hero = pHero;
    }

    // ================================================================== \\
    // =========================== OVERRIDES ============================ \\
    // ================================================================== \\
    public String toString(){
        return "Player[ Hero: "+ this.getHero().getNom() + "\n" + this.deck.toString() + " ]";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
