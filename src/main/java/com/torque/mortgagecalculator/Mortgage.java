package com.torque.mortgagecalculator;

import org.springframework.web.bind.annotation.RequestBody;

public class Mortgage {
    // TODO: doubles are not good for money, use Decimal
    private double totalsum;
    private double annual_percent;
    private double term;
    private double residual_value;

    public Mortgage(double totalsum, double annual_percent, double term, double residual_value) {
        this.totalsum = totalsum;
        this.annual_percent = annual_percent;
        this.term = term;
        this.residual_value = residual_value;
    }

    public double getTotalsum() {
        return totalsum;
    }

    public void setTotalsum(double totalsum) {
        this.totalsum = totalsum;
    }

    public double getAnnual_percent() {
        return annual_percent;
    }

    public void setAnnual_percent(double annual_percent) {
        this.annual_percent = annual_percent;
    }

    public double getTerm() {
        return term;
    }

    public void setTerm(double term) {
        this.term = term;
    }

    public double getResidual_value() {
        return residual_value;
    }

    public void setResidual_value(double residual_value) {
        this.residual_value = residual_value;
    }
}
