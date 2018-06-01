package com.home.exception;
//Exception quand il n'y a pas assez de mana pour jouer une carte
public class lowManaException extends Exception {
    public lowManaException(String message){
        super(message);
    }
}
