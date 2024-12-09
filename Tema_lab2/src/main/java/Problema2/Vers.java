package Problema2;

import java.io.*;
import java.util.*;

class Vers {
    private String vers;

    public Vers(String vers) {
        this.vers = vers;
    }

    public int numarCuvinte() {
        String[] cuvinte = vers.split("\\s+");
        return cuvinte.length;
    }

    public int numarVocale() {
        int numarVocale = 0;
        String vocale = "aeiouAEIOU";
        for (char c : vers.toCharArray()) {
            if (vocale.indexOf(c) != -1) {
                numarVocale++;
            }
        }
        return numarVocale;
    }

    public boolean verificaGrupa(String grupa) {
        return vers.endsWith(grupa);
    }

    public String inMajuscule() {
        Random rand = new Random();
        double numarAleator = rand.nextDouble();
        if (numarAleator < 0.1) {
            return vers.toUpperCase();
        }
        return vers;
    }

    public String getVers() {
        return vers;
    }
}
