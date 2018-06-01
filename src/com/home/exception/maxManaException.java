package com.home.exception;
//Exception quand on ne peut plus ajouter de mana a un joueur car il possede deja la valeur de mana maximum
public class maxManaException extends Exception {
    public maxManaException(String message){
        super(message);
    }
}
