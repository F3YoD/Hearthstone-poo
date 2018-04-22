package com.home.effets;

public class Pouvoir {
    // ================================================================== \\
    // =========================== CONSTANTS ============================ \\
    // ================================================================== \\
    public static final String FEU = "feu";
    public static final String FORCE = "force";
    // ================================================================== \\
    // =========================== ATTRIBUTS ============================ \\
    // ================================================================== \\
    private String type;
    private int degats;
    // ================================================================== \\
    // =========================== CONSTRUCT ============================ \\
    // ================================================================== \\
    public Pouvoir(String pType, int pDegats){
        this.setDegats(pDegats);
        this.setType(pType);
    }

    // ================================================================== \\
    // =========================== GETS/SETS ============================ \\
    // ================================================================== \\
    public String getType(){return this.type;}
    public int getDegats(){return this.degats;}

    public void setDegats(int pDegats){
        if(pDegats < 0)
            throw new IllegalArgumentException();

        this.degats = pDegats;
    }

    private void setType(String pType){
        if(!pType.trim().equals(FEU) && !pType.trim().equals(FORCE))
            throw new IllegalArgumentException();

        this.type = pType;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
