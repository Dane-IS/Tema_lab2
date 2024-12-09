package Problema4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;

class Persoana {
    private String nume;
    private String cnp;

    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public int getVarsta() {
        String an = cnp.substring(1, 3);
        String luna = cnp.substring(3, 5);
        String ziua = cnp.substring(5, 7);

        int anInt = Integer.parseInt(an);
        int lunaInt = Integer.parseInt(luna);
        int ziuaInt = Integer.parseInt(ziua);

        if (cnp.charAt(0) == '1' || cnp.charAt(0) == '2') {
            anInt += 1900;
        } else {
            anInt += 2000;
        }

        LocalDate dataNasterii = LocalDate.of(anInt, lunaInt, ziuaInt);
        LocalDate dataCurenta = LocalDate.now();

        return dataCurenta.getYear() - dataNasterii.getYear() -
                (dataCurenta.getDayOfYear() < dataNasterii.getDayOfYear() ? 1 : 0);
    }

    @Override
    public String toString() {
        return nume + ", " + cnp + ", " + getVarsta();
    }

    public static boolean esteCnpValid(String cnp) {
        if (cnp.length() != 13) {
            return false;
        }

        if (!cnp.matches("[0-9]+")) {
            return false;
        }

        char primaCifra = cnp.charAt(0);
        if (primaCifra != '1' && primaCifra != '2' && primaCifra != '5' && primaCifra != '6') {
            return false;
        }
        return true;
    }
}
