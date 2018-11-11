package com.company;

public class Electronica extends Producte {
    private int garantia;

    public Electronica (String codi, String nom, float preu, int dies){
        setCodiBarres(codiBarres);
        setNom(nom);
        setGarantia(dies);
        setPreu(preu);
    }

    public int getGarantia() {
        return garantia;
    }
    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    @Override
    public void setPreu(float preu){
        this.preu = (float)(preu+preu*this.garantia*0.1/365);
    }
}