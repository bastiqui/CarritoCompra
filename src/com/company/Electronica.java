package com.company;

public class Electronica extends Producte {
    private int garantia;

    public Electronica (String codi, String nom, float preu, int dies) {
        setCodiBarres(codi);
        setNom(nom);
        setGarantia(dies);
        setPreu(preu);
    }

    private void setGarantia (int garantia) {
        this.garantia = garantia;
    }

    @Override
    public void setPreu (float preu) {
        this.preu = ((float) (preu + preu * this.garantia * 0.1/365));
    }
}