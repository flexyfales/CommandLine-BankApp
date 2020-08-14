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
public class Customer {

    private final String firstName;
    private final String lastName;
    private final String ssn;
    private final Account account;

    
    
     Customer(String firstName ,String lastName, String ssn, Account account){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.account = account;
    }

    @Override
    public String toString() {
        return "\nCustomer Information{\n" + "firstName="+ firstName +"\n" + ", lastName=" + lastName +"\n" + ", ssn=" + ssn +"\n" + ", account=" + account + '}';
    }
     
     
        
    public String basicInfo() {
        return "\nCustomer Information{\n" + "firstName=" + firstName + ", lastName=" + lastName + ", ssn=" + ssn + ", Account Number =" + account + '}';
    }
    Account getAccount(){
         return account;
     }
    
}







