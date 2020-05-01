/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loanreceipt;

/**
 * A program that outputs neatly the loan amount, the annual interest, the months, 
 * the monthly interest rate, the monthly payment and the loan cost after interests.
 * Set loan_amount, annual_interest and months as attributes. Seperate the output 
 * in 2 category, one where the inputs from the keyboard will be neatly shown alongside
 * the monthly payment and the total interest paid. The other will show a schedule 
 * for the loan amortization in order.
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
//set an error message if the user inputs a negative integer, lam(loan amount)
    public void setLoanAmount(double lam) {
        this.loan_amount = lam;

        if (lam < 0) {
            throw new IllegalArgumentException("Loan: setLoanAmount: the loan amount must not be a negative number");
        }
    }
//set an error message if the user inputs a negative integer, air(annual interest rate)
    public void setAnnualInterestRate(double air) {
        this.annual_interest = air;

        if (air < 0) {
            throw new IllegalArgumentException("Loan: setAnualInterestRate: the annual interest rate must not be a negative number");
        }
    }
//set an error message if the user inputs a negative integer for the number of months
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

//return a String representing a table neatly starting with the loan amount, annual interest rate, loans term in months, monthly payments and total interest paid.
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
//set the getter for the monthly interest rate with the equation inside 
    public double getMonthlyInterestRate() {
        return this.annual_interest / 1200;

    }
//set the getter for the monthly payment with the equation inside
    public double getMonthlyPayment() {
        return ((getMonthlyInterestRate()) * (this.loan_amount)) / (1 - Math.pow(1 + (getMonthlyInterestRate()), -this.months));

    }
//set the getter method for the loan cost with the equation inside
    public double getloanCost() {
        return (((this.annual_interest / 1200) * (this.loan_amount)) / (1 - Math.pow(1 + (this.annual_interest / 1200), -this.months)) * this.months);

    }
//return a String representing a table with the month, interest paid, principal paid, loan balance
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

//make a loop that calculate the interest paid, principal paid, loan balance, that has the same amount of line as the length of the months
        for (int month = 0; month <= months; ++month) {
            if (month == 0) {
                result2 += "                                       " + loan_amount;
                result2 += "\n";
                continue;
            }
//set the equation for the interest paid           
            interestPaid = getMonthlyInterestRate() * previousBalance;

//set the equation for the principal
            principal = getMonthlyPayment() - interestPaid;
            
//set the previousBalance to the principal
            previousBalance -= principal;
            
//print the lines with the values
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
