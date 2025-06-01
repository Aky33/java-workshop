package com.calculator.calculator.service;

import com.calculator.calculator.model.Input;
import com.calculator.calculator.model.Output;

public class CalculatorService {
    public Output calculateMortgage(Input input) {
        double loanAmount = input.getVyseHypoteky();
            double annualRate = input.getUrokovaMira();
            int years = input.getDobaSplaceni();

            int periodsPerYear = switch (input.getIntervalSplaceni()) {
                case ROCNI -> 1;
                case PULROCNI -> 2;
                case CTVRTLETNI -> 4;
                case DVOUMESICNI -> 6;
                case MESICNI -> 12;
                case CTVRTMESICNI -> 24;
                case DENNI -> 365;
                default -> 12;
            };

            int totalPeriods = years * periodsPerYear;
            double ratePerPeriod = annualRate / periodsPerYear;

            double payment = (loanAmount * ratePerPeriod) /
                    (1 - Math.pow(1 + ratePerPeriod, -totalPeriods));

            double totalPaid = payment * totalPeriods;
            double totalInterest = totalPaid - loanAmount;
            double rpsn = calculateRpsn(loanAmount, payment, totalPeriods, periodsPerYear);

            return new Output(payment, totalPaid, totalInterest, rpsn);
    }

    private double calculateRpsn(double loanAmount, double payment, int periods, int periodsPerYear) {
        final double precision = 1e-6;
        double low = 0.0001, high = 1.0;

        while ((high - low) > precision) {
            double mid = (low + high) / 2;
            double pv = calculatePresentValue(payment, periods, mid, periodsPerYear);
            double target = loanAmount;

            if (pv > target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return ((low + high) / 2) * 100;
    }

    private double calculatePresentValue(double payment, int periods, double rate, int periodsPerYear) {
        double pv = 0.0;
        for (int i = 1; i <= periods; i++) {
            pv += payment / Math.pow(1 + rate, (double) i / periodsPerYear);
        }
        return pv;
    }
}
