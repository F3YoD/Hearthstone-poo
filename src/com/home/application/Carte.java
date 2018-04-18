package com.home.application;

public abstract class Carte {
    private String nom;
    private int pv;
    private int cout;
    private int degats;

    // ====================== constructeur ================== \\
    public Carte(){
        nom = null;
        pv=0;
        cout=0;
        degats=0;
    }

    public Carte(String nom,int pv,int cout,int degats){
        this.nom=nom;
        this.pv=pv;
        this.cout=cout;
        this.degats=degats;
    }

    //setter
    public void setCout(int cout) {
        if (cout > 0) {
            this.cout = cout;
        }
        else {
            System.err.println("le cout est inférieure a 1");
            System.exit(-1);
        }
    }

    public void setDegats(int degats) {
        if (degats >= 0) {
            this.degats = degats;
        }
        else{
            System.err.println("les degats sont inférieurs a 0");
            System.exit(-1);
        }
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPv(int pv) {
        if (pv > 0) {
            this.pv = pv;
        }
        else{
            System.err.println("le nombre de pv est inférieure a 1");
            System.exit(-1);
        }
    }

    //getter


    public int getCout() {
        return cout;
    }

    public int getDegats() {
        return degats;
    }

    public int getPv() {
        return pv;
    }

    public String getNom() {
        return nom;
    }

}
