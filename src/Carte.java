public class Carte {
    private String nom;
    private int pv;
    private int cout;
    private int degats;

    //setter
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
}
