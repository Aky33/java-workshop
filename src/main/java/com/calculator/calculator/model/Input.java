package com.calculator.calculator.model;

public class Input {
    //Výše úvěru
    private Double vyseHypoteky;
    //Úroková míra, e.g. 5,00%
    private Double urokovaMira;
    //Doba splácení, e.g. 30let
    private Integer dobaSplaceni;

    private IntervalSplaceni intervalSplaceni;

    public Input() {

    }

    public Input(Double vyseHypoteky, Double urokovaMira, Integer dobaSplaceni) {
        this.vyseHypoteky = vyseHypoteky;
        this.urokovaMira = urokovaMira;
        this.dobaSplaceni = dobaSplaceni;
    }

    public Double getVyseHypoteky() {
        return vyseHypoteky;
    }

    public Double getUrokovaMira() {
        return urokovaMira / 100.0;   //Předpokládáme že od uživatele přijde jako procenta
    }

    public Integer getDobaSplaceni() {
        return dobaSplaceni;
    }

    public IntervalSplaceni getIntervalSplaceni() {
        return intervalSplaceni;
    }
}