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
    
    public Loan(double loan_amount, double annual_interest, int months){
        this.loan_amount = loan_amount;
        this.annual_interest = annual_interest;
        this.months = months;
    }
    
    public void setLoanAmount(double lam){
        this.loan_amount = lam;
    }
}
