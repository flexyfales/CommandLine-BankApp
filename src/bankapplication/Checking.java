/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

/**
 *
 * @author Felix
 */
public class Checking extends Account{
    private static String accountType="Checking";
    Checking(double initialDeposit){
        super();
        this.setBalance(initialDeposit);
        this.checkInterest();
    }

    @Override
    public String toString() {
        return "AccountType:"+accountType+"Account\n" +"Account Number" + this.getAccountNumber() +"\n" +"Balance"+ this.getBalance()+"\n" 
                +"Interest Rate" + this.getInterest()+"%\n";
    }
    
   
}





