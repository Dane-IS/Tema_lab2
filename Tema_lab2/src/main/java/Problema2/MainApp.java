package Problema2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        List<Vers> versuri = citesteVersuriDinFisier("D:/Cursuri faculta/Teme lab PJ/Tema_lab2/src/main/java/Problema2/cantec_in.txt");
        scrieInFisier("cantec_out.txt", versuri);
    }

    public static List<Vers> citesteVersuriDinFisier(String fisierIntrare) {
        List<Vers> versuri = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fisierIntrare))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                versuri.add(new Vers(linie.trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return versuri;
    }

    public static void scrieInFisier(String fisierIesire, List<Vers> versuri) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fisierIesire))) {
            for (Vers vers : versuri) {
                String linie = vers.inMajuscule();
                int cuvinte = vers.numarCuvinte();
                int vocale = vers.numarVocale();
                bw.write(linie + " " + cuvinte + " " + vocale);

                if (vers.verificaGrupa("aa"))
                {
                    bw.write(" *");
                }

                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
