package com.example.mymoney.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Model danych dodania rachunku
 */

public class AccountRecord implements Serializable {

    private String nazwaRachunku;
    private Double saldoRachunkuPLN;


    public String getNazwaRachunku() {
        return nazwaRachunku;
    }

    public void setNazwaRachunku(String nazwaRachunku) {
        this.nazwaRachunku = nazwaRachunku;
    }

    public Double getSaldoRachunkuPLN() {
        return saldoRachunkuPLN;
    }

    public void setSaldoRachunkuPLN(Double saldoRachunkuPLN) {
        this.saldoRachunkuPLN = saldoRachunkuPLN;
    }

    public AccountRecord(Date wydatekData, Double wydatekKwotaPLN, String wydatekCel) {
        this.nazwaRachunku = nazwaRachunku;
        this.saldoRachunkuPLN = saldoRachunkuPLN;
    }

}
