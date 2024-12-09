package Problema4;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceti numarul de persoane: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Persoana> persoane = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Numele este: " + (i + 1) + ": ");
            String nume = scanner.nextLine();

            String cnp;
            while (true) {
                System.out.print("CNP-ul este: " + (i + 1) + ": ");
                cnp = scanner.nextLine();

                if (Persoana.esteCnpValid(cnp)) {
                    break;
                } else {
                    System.out.println("CNP-ul nu este valid");
                }
            }

            persoane.add(new Persoana(nume, cnp));
        }

        for (Persoana persoana : persoane) {
            System.out.println(persoana);
        }

        scanner.close();
    }
}
