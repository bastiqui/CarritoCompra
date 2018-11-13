package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static float preuu[] = new float[100];
    private static int j = 0;

    private static void mostraProductes(ArrayList<Producte> producte){
        System.out.println("Producte\tQuantitat\tPreu");
        for(int i = 0; i < producte.size(); i++) {
            System.out.printf("\t%s\t\t\t%d\t\t%.2f%n", producte.get(i).getNom(), producte.get(i).getQuantitat(), producte.get(i).getPreu()*producte.get(i).getQuantitat() );
        }
    }

    private static void showTicket(ArrayList<Producte> producte){
        float preu = 0;
        for(int i = 0; i < producte.size(); i++) {
            preu+=producte.get(i).getPreu()*producte.get(i).getQuantitat();
        }
        System.out.printf("Preu: %.2f%n", preu);
    }

    private static void addAlimentacio(ArrayList<Producte> producte) throws ParseException, IOException {
        boolean ot = false;

        System.out.print("Codi: ");
        String codi = br.readLine();
        System.out.print("Preu: ");
        float preu = Float.parseFloat(br.readLine());
        for (int i = 0; i < producte.size(); i++) {
            if(codi.equals(producte.get(i).getCodiBarres()) && preu == preuu[i]){
                producte.get(i).setQuantitat(producte.get(i).getQuantitat()+1);
                ot = true;
            }
        }
        if (!ot){
            System.out.print("Nom: ");
            String nom = br.readLine();
            System.out.println("Data de caducitat (dd/mm/aaaa)");
            String data = br.readLine();
            producte.add(new Alimentacio(codi,nom,preu,data));
        }
    }

    private static void addElectronica(ArrayList<Producte> producte) throws IOException{
        boolean ot = false;

        System.out.print("Codi: ");
        String codi = br.readLine();
        System.out.print("Preu: ");
        float preu = Float.parseFloat(br.readLine());
        preuu[j] = preu;
        for (int i = 0; i < producte.size(); i++) {
            if(codi.equals(producte.get(i).getCodiBarres()) && preu == preuu[i]) {
                producte.get(i).setQuantitat(producte.get(i).getQuantitat() + 1);
                ot = true;
            }
        }
        if (!ot){
            System.out.print("Nom: ");
            String nom = br.readLine();
            System.out.print("Dies de garantia: ");
            int dies = Integer.parseInt(br.readLine());
            producte.add(new Electronica(codi,nom,preu,dies));
        }
    }

    private static void addTextil(ArrayList<Producte> producte) throws IOException{
        boolean ot = false;

        System.out.print("Codi: ");
        String codi = br.readLine();
        System.out.print("Preu: ");
        float preu = Float.parseFloat(br.readLine());
        preuu[j] = preu;
        for (int i = 0; i < producte.size(); i++) {
            if(codi.equals(producte.get(i).getCodiBarres()) && producte.get(i).getPreu() == preuu[i]){
                producte.get(i).setQuantitat(producte.get(i).getQuantitat()+1);
                ot = true;
            }
        }
        if (!ot){
            System.out.print("Nom: ");
            String nom = br.readLine();
            System.out.print("Material: ");
            String mat = br.readLine();
            producte.add(new Textil(codi,nom,preu,mat));
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        int escogirMenu, escogirProducte;
        ArrayList<Producte> producte = new ArrayList <Producte>();

        do {
            escogirMenu = menuSuper();
            switch (escogirMenu) {
                case 1:
                    escogirProducte = menuProducte();
                    switch (escogirProducte) {
                        case 1:
                            addAlimentacio(producte);
                            break;
                        case 2:
                            addTextil(producte);
                            break;
                        case 3:
                            addElectronica(producte);
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Opcio no valida");
                            break;
                    }
                    break;
                case 2:
                    mostraProductes(producte);
                    showTicket(producte);
                    break;
                case 3:
                    mostraProductes(producte);
                    break;
                case 0:
                    System.out.println("Gracias per la seva visita.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcio no valida");
                    break;
            }
        } while (escogirMenu != 0);
    }

    private static int menuSuper () throws IOException {
        System.out.println("|--------- PuigMarket ---------|");
        System.out.println("|      1 - Afegir Producte     |");
        System.out.println("|      2 - Passar per caixa    |");
        System.out.println("|      3 - Mostrar carro       |");
        System.out.println("|      0 - Sortir              |");
        System.out.println("|------------------------------|");
        System.out.print("Què vols fer? ");
        int opcio = Integer.parseInt(br.readLine());
        return opcio;
    }

    private static int menuProducte () throws IOException {
        int opcio;
            System.out.println("|----- Afegir Producte -----|");
            System.out.println("|    1 - Alimentació        |");
            System.out.println("|    2 - Tèxtil             |");
            System.out.println("|    3 - Electrònica        |");
            System.out.println("|    0 - Tornar             |");
            System.out.println("|---------------------------|");
            System.out.print("Quin Producte vols afegir? ");
            opcio = Integer.parseInt(br.readLine());
        return opcio;
    }
}
