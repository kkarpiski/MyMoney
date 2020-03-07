package com.example.mymoney.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Model danych wydatków
 */

public class WydatkiData implements Serializable {

    /**
     * Kolekcja wydatków
     */
    private List<WydatekRecord> wydatekRecord ;
    private String jedzenie;
    private String rozrywka;
   // private String oplaty;
  // private String samochod;
   // private String wakacje;


    public WydatkiData(String jedzenie) {
        this.jedzenie = jedzenie;
        this.rozrywka = rozrywka;
       // this.oplaty = oplaty;
       // this.samochod = samochod;
       // this.wakacje = wakacje;
        wydatekRecord = new ArrayList<>();
    }

    public String getJedzenie() {
        return jedzenie;
    }

    public void setJedzenie(String jedzenie) {
        this.jedzenie = jedzenie;
    }

    public String getRozrywka() {
        return rozrywka;
    }

    public void setRozrywka(String rozrywka) {
        this.rozrywka = rozrywka;
    }

    public List<WydatekRecord> getWydatekRecord() {
        return wydatekRecord;
    }

    public void setWydatekRecord(List<WydatekRecord> wydatekRecord) {
        this.wydatekRecord = wydatekRecord;
    }
/*
    public String getOplaty() {
        return oplaty;
    }

    public void setOplaty(String oplaty) {
        this.oplaty = oplaty;
    }

    public String getSamochod() {
        return samochod;
    }

    public void setSamochod(String samochod) {
        this.samochod = samochod;
    }

    public String getWakacje() {
        return wakacje;
    }

    public void setWakacje(String wakacje) {
        this.wakacje = wakacje;
    }

 */
}
