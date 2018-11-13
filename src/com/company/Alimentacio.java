package com.company;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Alimentacio extends Producte {
    private Date caducitat;

    public Alimentacio (String codiBarres, String nom, float preu , String data) throws ParseException {
        setNom(nom);
        setCodiBarres(codiBarres);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = df.parse(data);
        setCaducitat(date);
        setPreu(preu);
    }

    public Date getCaducitat() {
        return caducitat;
    }

    private void setCaducitat (Date caducitat) {
        this.caducitat = caducitat;
    }

    @Override
    public void setPreu (float preu){
        Date dataActual = new Date();
        float tempsCaducitat = caducitat.getTime() - dataActual.getTime();
        //la numeració es en segons
        tempsCaducitat = (tempsCaducitat/1000)/86400;
        this.preu = ((float) (preu - preu/(tempsCaducitat+1) + preu*0.1));
    }
}