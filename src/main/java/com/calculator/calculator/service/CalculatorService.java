package com.calculator.calculator.service;

import java.text.DecimalFormat;

import com.calculator.calculator.model.Input;
import com.calculator.calculator.model.Output;

public class CalculatorService {
    public Output calculateMortgage(Input input) {
        var loanAmount = input.getVyseHypoteky();
        var years = input.getDobaSplaceni();
        var fixations = input.getDobaFixace(); // nevyužito
        var fee = input.getVyseSplatky();
 
        var annualRate = 0.05; // pevná roční úroková sazba 5 %
        var monthlyRate = annualRate / 12;
        var months = years * 12;
 
        var monthlyPayment = (loanAmount * monthlyRate) /
            (1 - Math.pow(1 + monthlyRate, -months));
 
        var rpsn = calculateRpsn(loanAmount, monthlyPayment, months, fee);
 
        var df = new DecimalFormat("#,##0.00");
 
        return new Output(monthlyPayment, rpsn);
    }
 
    private double calculateRpsn(double loanAmount, double monthlyPayment, int months, double fee) {
        final double precision = 1e-6;
        var rpsn = 0.01; // počáteční odhad (1 %)
        final double step = 0.0001;
 
        while (true) {
            var pv = 0.0;
            for (int i = 1; i <= months; i++) {
                pv += monthlyPayment / Math.pow(1 + rpsn, i / 12.0);
            }
 
            var target = loanAmount - fee;
            var diff = pv - target;
 
            if (Math.abs(diff) < precision) break;
 
            rpsn += (diff > 0) ? -step : step;
            if (rpsn < 0) rpsn = 0.0001;
        }
 
        return rpsn * 100;
    }
}
