package com.company;

public abstract class Producte {
    private String nom;
    public String codiBarres;
    public float preu;

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodiBarres() {
        return codiBarres;
    }
    public void setCodiBarres(String codiBarres) {
        this.codiBarres = codiBarres;
    }

    private float getPreu() {
        return preu;
    }
    public void setPreu(float preu) {
        this.preu = preu;
    }
}