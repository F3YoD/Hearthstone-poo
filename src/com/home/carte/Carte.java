package com.home.carte;

import com.home.Environement.Plateau;
import com.home.effets.Capacite;
import com.home.exception.lowManaException;

public abstract class Carte {
    // ================================================================== \\
    // =========================== ATTRIBUTS ============================ \\
    // ================================================================== \\
    private String nom;
    private int cout;
    private Capacite capacite;
    // ================================================================== \\
    // =========================== CONSTRUCT ============================ \\
    // ================================================================== \\

    public Carte(){}
    public Carte(String pNom, int pCout) {
            this.setNom(pNom);
            this.setCout(pCout);
    }

    public Carte(String pNom, int pCout,Capacite cap) {
        this.setNom(pNom);
        this.setCout(pCout);
        this.setCapacite(cap);
    }

    // ================================================================== \\
    // =========================== GETS/SETS ============================ \\
    // ================================================================== \\
    public String getNom(){return this.nom;}
    public int getCout(){return this.cout;}

    public void setNom(String pNom) throws IllegalArgumentException {
        if(pNom.trim().equals(""))
            throw new IllegalArgumentException();
        this.nom = pNom;
    }

    public void setCout(int pCout) throws IllegalArgumentException {
        if(pCout < 0)
            throw new IllegalArgumentException();

        this.cout = pCout;
    }

    public void setCapacite(Capacite capacite) {
        this.capacite = capacite;
    }

    public Capacite getCapacite() {
        return capacite;
    }

    public String dessinerHautCarte(){
        return " ____________________________________ ";
    }
    public String dessinerMidCarte1(){
        return "|                                    |";
    }
    public String dessinerMidCarte2(){
        String fin = "|      \033[32mnom:"+ this.nom ;
        while (fin.length()<29+5+8){
            fin += " ";
        }
        fin += "\033[0m|";
        return fin;
    }
    public String dessinerMidCarte3(){
        String fin ="|               \033[34mcout:"+this.cout;
        while (fin.length()<29+8+5){
            fin += " ";
        }
        fin += "\033[0m|";
        return fin;
    }
    public String dessinerMidCarte4(){
        return "|                                    |";
    }
    public String dessinerMidCarte5(){
        return "|                                    |";
    }
    public String dessinerMidCarte6(){
        String fin ="|      \033[33mcap:"+this.capacite.getDescription();
        while (fin.length()<29+5+8){
            fin += " ";
        }
        fin += "\033[0m|";
        return fin;
    }
    public String dessinerBasCarte(){
        return "|____________________________________|";
    }


    public abstract void lancer(Plateau plateau)throws lowManaException;
    //tostring todo


    @Override
    public String toString() {
        return "nom : " + this.nom +" cout :" +this.cout;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}