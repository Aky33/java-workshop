package com.calculator.calculator.model;

public class Output {
    private Double pravidelnaSplatka;
    private Double celkemZaplaceno;
    private Double celkoveUroky;
    private Double rpns;

    public Output() {

    }

    public Output(Double pravidelnaSplatka, Double celkemZaplaceno, Double celkoveUroky, Double rpns) {
        this.pravidelnaSplatka = pravidelnaSplatka;
        this.celkemZaplaceno = celkemZaplaceno;
        this.celkoveUroky = celkoveUroky;
        this.rpns = rpns;
    }

    public Double getPravidelnaSplatka() {
        return pravidelnaSplatka;
    }

    public Double getCelkemZaplaceno() {
        return celkemZaplaceno;
    }

    public Double getCelkoveUroky() {
        return celkoveUroky;
    }

    public Double getRpns() {
        return rpns;
    }

    public void setPravidelnaSplatka(Double pravidelnaSplatka) {
        this.pravidelnaSplatka = pravidelnaSplatka;
    }

    public void setCelkemZaplaceno(Double celkemZaplaceno) {
        this.celkemZaplaceno = celkemZaplaceno;
    }

    public void setCelkoveUroky(Double celkoveUroky) {
        this.celkoveUroky = celkoveUroky;
    }

    public void setRpns(Double rpns) {
        this.rpns = rpns;
    }
}
