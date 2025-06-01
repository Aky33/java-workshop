package com.calculator.calculator.model;

public class Input {
    private Double vyseHypoteky;
    private Integer dobaSplaceni;
    private Integer dobaFixace;
    private Double vyseSplatky;

    public Input() {

    }

    public Input(Double vyseHypoteky, Integer dobaSplaceni, Integer dobaFixace, Double vyseSplatky) {
        this.vyseHypoteky = vyseHypoteky;
        this.dobaSplaceni = dobaSplaceni;
        this.dobaFixace = dobaFixace;
        this.vyseSplatky = vyseSplatky;
    }

    public Double getVyseHypoteky() {
        return vyseHypoteky;
    }

    public Integer getDobaSplaceni() {
        return dobaSplaceni;
    }

    public Integer getDobaFixace() {
        return dobaFixace;
    }

    public Double getVyseSplatky() {
        return vyseSplatky;
    }

    public void setVyseHypoteky(Double vyseHypoteky) {
        this.vyseHypoteky = vyseHypoteky;
    }

    public void setDobaSplaceni(Integer dobaSplaceni) {
        this.dobaSplaceni = dobaSplaceni;
    }

    public void setDobaFixace(Integer dobaFixace) {
        this.dobaFixace = dobaFixace;
    }

    public void setVyseSplatky(Double vyseSplatky) {
        this.vyseSplatky = vyseSplatky;
    }
}
