package com.company;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Alimentacio extends Producte {
    private Date caducitat;

    public Alimentacio(String nom, String codiBarres, float preu , String data ) throws ParseException {
        setNom(nom);
        setCodiBarres(codiBarres);
        setPreu(preu);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = df.parse(data);
    }
    public Date getCaducitat() {
        return caducitat;
    }

    @Override
    public void setPreu(float preu){
        Date factual = new Date();
        float dif = caducitat.getTime() - factual.getTime();
        //la numeración es en segundos
        dif = (dif/1000)/86400;
        this.preu = (float) (preu - preu/(dif+1) + preu*0.1);

    }

}

