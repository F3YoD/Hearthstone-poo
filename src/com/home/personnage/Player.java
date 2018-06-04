package com.home.personnage;

import com.home.Environement.Deck;
import com.home.Environement.Main;
import com.home.Environement.Terrain;

/**
 * <b>la class Player est tout ce que le joueur possède</b>
 * <p>
 * il possède
 * </p>
 * <ul>
 *     <li>sa deck (ses cartes)</li>
 *     <li>son hero</li>
 *     <li>sa main (ses cartes dans sa main)</li>
 *     <li>son terrain (ses cartes sur le plateau)</li>
 * </ul>
 * @author yoann/pierre
 */
public class Player {
    // ================================================================== \\
    // =========================== ATTRIBUTS ============================ \\
    // ================================================================== \\
    private Deck deck;
    private Hero hero;
    private Main main;
    private Terrain terrain;

    // ================================================================== \\
    // =========================== CONSTRUCT ============================ \\
    // ================================================================== \\
    public Player(Hero pHero, Deck deck,Main main,Terrain terrain){
        this.setDeck(deck);
        this.setHero(pHero);
        this.setMain(main);
        this.setTerrain(terrain);
    }

    // ================================================================== \\
    // =========================== GETS/SETS ============================ \\
    // ================================================================== \\
    public Deck getDeck(){return this.deck;}
    public Hero getHero(){return this.hero;}

    public Main getMain() {
        return main;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setDeck(Deck deck){
        this.deck = deck;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setHero(Hero pHero){
        if(!pHero.getNom().equals("rexar") && !pHero.getNom().equals("jaina"))
            throw new IllegalArgumentException();

        this.hero = pHero;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    // ================================================================== \\
    // =========================== OVERRIDES ============================ \\
    // ================================================================== \\
    public String toString(){

        return "Player[ Hero: "+ this.getHero().toString() + "\n Deck:" + this.deck.toString() + "\n Main :" + this.main.toString() + "\n Terrain : " + this.terrain.toString() +" ]";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
