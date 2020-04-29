/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loanreceipt;
import java.util.*;

/**
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
            
            kb.nextLine();
            
            
        }while (kb.nextLine().equals("y"));
      
        System.out.println("goodbye!");
        

    } 
    
}
