package com.home.exception;
//Exception qui se lance quand on veut attaquer avec une carte alors qu'elle doit attendre un tour avant d'attaquer
public class attenteException extends Exception{
    public attenteException(String msg){
        super(msg);
    }
}
