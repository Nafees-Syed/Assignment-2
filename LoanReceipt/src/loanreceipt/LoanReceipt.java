/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loanreceipt;
import java.util.*;

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
public class LoanReceipt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         Scanner kb = new Scanner(System.in);
        String answer; 
        
        do 
        {
            System.out.println("Enter the loan amount: ");
            double loan = kb.nextDouble();
            
            System.out.println("Enter the annual " + "interest rate: ");
            double interestRate = kb.nextDouble();
            
            System.out.println("Enter loan's term in months ");
            int months  = kb.nextInt();
            
            Loan a_loan = new Loan(loan, interestRate, months);
            
            System.out.println(a_loan);
            System.out.println(a_loan.amortize());
            
            System.out.println("Would you like to run another report?\n" + "Enter Y or y for yes, or any other charachter for no: ");
            
           answer = kb.next();
            
            
        }while (answer.equals("y"));
      
        System.out.println("goodbye!");
        

    } 
    
}
