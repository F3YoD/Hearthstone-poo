import java.util.ArrayList;

public class Main {
    private int nb_carte; //nombre de carte actuellement dans la main;
    private ArrayList<Carte> liste_carte;

    //constructeur
    public Main(){
        this.nb_carte=0;
        this.liste_carte=new ArrayList<>();
    }

    //setter
    public void setNbcartes(int nombre){
        if (nombre > 0) {
            this.nb_carte = nombre;
        }
        else{
            System.err.println("le nombre de carte est inférieure a 1");
            System.exit(-1);
        }
    }


    //a faire : setteur qui permet de piocher aléatoirement une carte


    //getter

    public int getNbcartes(){
        return this.nb_carte;
    }

    public ArrayList<Carte> getListecarte(){
        return this.liste_carte;
    }

    public boolean equals(Main main2){
        return this.liste_carte==main2.liste_carte;
    }

    //toString et a faire
}
