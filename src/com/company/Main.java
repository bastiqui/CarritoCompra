package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Main {
    //Variables que s'han de fer servir en tot el programa
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //Array per anar guardant el preu de cada producte afegit, com a maxim 50 productes
    private static float preuProducte[] = new float[50];
    private static int p = 0;

    private static void showProductes (ArrayList<Producte> producte){
        System.out.println("Producte\tQuantitat");
        for(int i = 0; i < producte.size(); i++) {
            System.out.printf("%s\t\t\t\t%d%n", producte.get(i).getNom(), producte.get(i).getQuantitat());
        }
    }

    private static void showTicket(ArrayList<Producte> producte){
        float preu = 0;
        String timeStamp = new SimpleDateFormat("HH:mm\tdd/MM/yyyy").format(Calendar.getInstance().getTime());

        System.out.println("--------------- Puig Market ---------------");

        System.out.println("Data de compra: " + timeStamp + "\n");

        System.out.println("Producte\tQuantitat\tPreu Unitari\tPreu");

        for(int i = 0; i < producte.size(); i++) {
            System.out.printf("%s\t\t\t%d\t\t\t%.2f €\t\t\t%.2f €%n", producte.get(i).getNom(), producte.get(i).getQuantitat(), producte.get(i).getPreu(), producte.get(i).getPreu()*producte.get(i).getQuantitat() );
        }

        for(int i = 0; i < producte.size(); i++) {
            preu+=producte.get(i).getPreu()*producte.get(i).getQuantitat();
        }
        System.out.printf("\nPreu TOTAL: %.2f €%n", preu);
        System.out.println("-------------------------------------------");
    }

    private static void addAlimentacio (ArrayList<Producte> producte) throws ParseException, IOException {
        //Booleà per comprovar si un producte introduït està repetit
        boolean producteRep = false;

        System.out.print("Codi: ");
        String codi = br.readLine();
        System.out.print("Preu: ");
        float preu = Float.parseFloat(br.readLine());
        //Recorregut per l'array per comprovar si està repetit
        for (int i = 0; i < producte.size(); i++) {
            if(codi.equals(producte.get(i).getCodiBarres())){
                producte.get(i).setQuantitat(producte.get(i).getQuantitat()+1);
                producteRep = true;
                System.out.println("Producte existent en carro, afegint una unitat.");
            }
        }
        if (!producteRep){
            System.out.print("Nom: ");
            String nom = br.readLine();
            System.out.println("Data de caducitat (dd/mm/aaaa)");
            String data = br.readLine();
            producte.add(new Alimentacio(codi, nom, preu, data));
        }
        //Aument de l'array de int per poder introduïr més productes
        p++;
    }

    private static void addElectronica(ArrayList<Producte> producte) throws IOException{
        boolean producteRep = false;

        System.out.print("Codi: ");
        String codi = br.readLine();
        System.out.print("Preu: ");
        float preu = Float.parseFloat(br.readLine());
        preuProducte[p] = preu;
        for (int i = 0; i < producte.size(); i++) {
            if(codi.equals(producte.get(i).getCodiBarres())) {
                producte.get(i).setQuantitat(producte.get(i).getQuantitat() + 1);
                producteRep = true;
                System.out.println("Producte existent en carro, afegint una unitat.");
            }
        }
        if (!producteRep){
            System.out.print("Nom: ");
            String nom = br.readLine();
            System.out.print("Dies de garantia: ");
            int dies = Integer.parseInt(br.readLine());
            producte.add(new Electronica(codi,nom,preu,dies));
        }
        p++;
    }

    private static void addTextil(ArrayList<Producte> producte) throws IOException{
        boolean producteRep = false;

        System.out.print("Codi: ");
        String codi = br.readLine();
        System.out.print("Preu: ");
        float preu = Float.parseFloat(br.readLine());
        preuProducte[p] = preu;
        for (int i = 0; i < producte.size(); i++) {
            if(codi.equals(producte.get(i).getCodiBarres())){
                producte.get(i).setQuantitat(producte.get(i).getQuantitat()+1);
                producteRep = true;
                System.out.println("Producte existent en carro, afegint una unitat.");
            }
        }
        if (!producteRep){
            System.out.print("Nom: ");
            String nom = br.readLine();
            System.out.print("Composicio: ");
            String composicio = br.readLine();
            producte.add(new Textil(codi, nom, preu, composicio));
        }
        p++;
    }

    public static void main(String[] args) throws IOException, ParseException {
        int escogirMenu, escogirProducte;
        ArrayList<Producte> producte = new ArrayList <>();

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
                    showTicket(producte);
                    break;
                case 3:
                    showProductes(producte);
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
