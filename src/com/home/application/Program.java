package com.home.application;

public class Program {

    public static void main(String argv[]){
        // declaration des objets
        Player player1 = new Player(30, new Main());
        System.out.println("" + player1.toString());
    }
}