/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loanreceipt;

/**
 *
 * @author Natsu
 */
public class Loan {

    private double loan_amount;
    private double annual_interest;
    private int months;

    public Loan(double loan_amount, double annual_interest, int months) {
        this.loan_amount = loan_amount;
        this.annual_interest = annual_interest;
        this.months = months;
    }

    public void setLoanAmount(double lam) {
        this.loan_amount = lam;

        if (lam < 0) {
            throw new IllegalArgumentException("Loan: setLoanAmount: the loan amount must not be a negative number");
        }
    }

    public void setAnnualInterestRate(double air) {
        this.annual_interest = air;

        if (air < 0) {
            throw new IllegalArgumentException("Loan: setAnualInterestRate: the annual interest rate must not be a negative number");
        }
    }

    public void setMonths(int month) {
        this.months = month;

        if (month < 0) {
            throw new IllegalArgumentException("Loan: setMonths: the loan in months must not be a negative number");
        }
    }

    public double getLoanAmount() {
        return this.loan_amount;
    }

    public double getAnnualInterestRate() {
        return this.annual_interest;
    }

    public int getMonths() {
        return this.months;
    }

    @Override
    public String toString() {

        String result = "";

        result += "-----------------------------------------\n";
        result += "               Loan Report               \n";
        result += "-----------------------------------------\n";
        result += "Loan Amount: $" + getLoanAmount() + "\n";
        result += "Annual Interest Rate: " + getAnnualInterestRate() + "%\n";
        result += "Loan's term in months: " + getMonths() + "\n";
        result += "Monthly payments: $" + ((getAnnualInterestRate() / 1200) * (getLoanAmount())) / (1 - Math.pow(1 + (getAnnualInterestRate() / 1200), -getMonths())) + "\n";
        result += "Total intterest paid: $" + (((getAnnualInterestRate() / 1200) * (getLoanAmount())) / (1 - Math.pow(1 + (getAnnualInterestRate() / 1200), -getMonths())) * getMonths() - (getLoanAmount())) + "\n";
        result += "------------------------------------------\n";
        return result;

    }

    public double getMonthlyInterestRate() {
        return this.annual_interest / 1200;

    }

    public double getMonthlyPayment() {
        return ((getMonthlyInterestRate()) * (this.loan_amount)) / (1 - Math.pow(1 + (getMonthlyInterestRate()), -this.months));

    }

    public double getloanCost() {
        return (((this.annual_interest / 1200) * (this.loan_amount)) / (1 - Math.pow(1 + (this.annual_interest / 1200), -this.months)) * this.months);

    }

    public String amortize() {
        String result2 = "";
        double interestPaid = 0.0;
        double principal = 0.0;
        double previousBalance = loan_amount;

        result2 += "--------------------------------------------------------------\n";
        result2 += "             Amortization Schedule \n";
        result2 += "                Monthly Payment \n";
        result2 += "              $" + getMonthlyPayment() + "\n";
        result2 += "--------------------------------------------------------------\n";
        result2 += " Month     Interest     Principal     Loan \n";
        result2 += "           Paid         Paid          Balance \n";
        result2 += "--------------------------------------------------------------\n";

        for (int month = 0; month <= months; ++month) {
            if (month == 0) {
                result2 += "                                       " + loan_amount;
                result2 += "\n";
                continue;
            }
            interestPaid = getMonthlyInterestRate() * previousBalance;

            principal = getMonthlyPayment() - interestPaid;

            previousBalance -= principal;

            result2 += month + "          ";
            result2 += Math.round(interestPaid * 100.0) / 100.0 + "         ";
            result2 += Math.round(principal * 100.0) / 100.0 + "         ";
            result2 += Math.round(previousBalance * 100.0) / 100.0 + "               ";

            result2 += "\n";
        }

        result2 += "--------------------------------------------------------------\n";
        result2 += "Totals" + getloanCost() + "      " + loan_amount;
        return result2;

    }
}
