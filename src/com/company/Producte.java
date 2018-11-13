package com.company;

public class Producte {
    private String nom;
    private String codiBarres;
    float preu;
    //S'ha d'inicar la variable per fer els comptes.
    private int quantitat = 1;

    public void setQuantitat (int quantitat) {
        this.quantitat = quantitat;
    }

    public int getQuantitat () {
        return quantitat;
    }

    public String getNom () {
        return nom;
    }
    public void setNom (String nom) {
        this.nom = nom;
    }

    public String getCodiBarres () {
        return codiBarres;
    }
    public void setCodiBarres (String codiBarres) {
        this.codiBarres = codiBarres;
    }

    public float getPreu () {
        return preu;
    }
    public void setPreu (float preu) {
        this.preu = preu;
    }
}