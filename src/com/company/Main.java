package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int escogirMenu, escogirProducte;

        do {
            escogirMenu = menuSuper();
            switch (escogirMenu) {
                case 1:
                    escogirProducte = menuProducte();
                    switch (escogirProducte) {
                        case 1:
                            System.out.println("Alimentacio");
                            break;
                        case 2:
                            System.out.println("Textil");
                            break;
                        case 3:
                            System.out.println("Electronica");
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Opcio no valida");
                            break;
                    }
                    break;
                case 2:
                    break;
                case 3:
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

    private static int menuSuper () {
        System.out.println("|--------- PuigMarket ---------|");
        System.out.println("|      1 - Afegir producte     |");
        System.out.println("|      2 - Passar per caixa    |");
        System.out.println("|      3 - Mostrar carro       |");
        System.out.println("|      0 - Sortir              |");
        System.out.println("|------------------------------|");
        System.out.print("Què vols fer? ");
        int opcio = scanner.nextInt();
        scanner.nextLine();
        return opcio;
    }

    private static int menuProducte () {
        int opcio;
            System.out.println("|----- Afegir producte -----|");
            System.out.println("|    1 - Alimentació        |");
            System.out.println("|    2 - Tèxtil             |");
            System.out.println("|    3 - Electrònica        |");
            System.out.println("|    0 - Tornar             |");
            System.out.println("|---------------------------|");
            System.out.print("Quin producte vols afegir? ");
            opcio = scanner.nextInt();
            scanner.nextLine();
        return opcio;
    }
}
