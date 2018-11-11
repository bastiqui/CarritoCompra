package com.company;

public class Textil extends Producte{
    private String composicio;

    public Textil (String codiBarres, String nom, float preu, String composicio){
        setCodiBarres(codiBarres);
        setNom(nom);
        setPreu(preu);
        setComposicio(composicio);
    }

    public String getComposicio() {
        return composicio;
    }

    public void setComposicio(String composicio) {
        this.composicio = composicio;
    }
}
