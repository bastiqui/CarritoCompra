package com.company;

public class Textil extends Producte{
    private String composicio;

    Textil(String codiBarres, String nom, float preu, String composicio){
        setCodiBarres(codiBarres);
        setNom(nom);
        setPreu(preu);
        setComposicio(composicio);
    }

    private void setComposicio(String composicio) {
        this.composicio = composicio;
    }

    @Override
    public void setPreu(float preu){
        this.preu = ((float) (preu + (preu * 0.1/365)));
    }
}