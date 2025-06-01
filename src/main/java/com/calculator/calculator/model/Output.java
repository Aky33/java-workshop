package com.calculator.calculator.model;

public class Output {
    private Double vyseSplatky;
    private Double rpns;

    public Output() {

    }

    public Output(Double vyseSplatky, Double rpns) {
        this.vyseSplatky = vyseSplatky;
        this.rpns = rpns;
    }

    public Double getVyseSplatky() {
        return vyseSplatky;
    }

    public Double getRpns() {
        return rpns;
    }

    public void setVyseSplatky(Double vyseSplatky) {
        this.vyseSplatky = vyseSplatky;
    }

    public void setRpns(Double rpns) {
        this.rpns = rpns;
    }
}
