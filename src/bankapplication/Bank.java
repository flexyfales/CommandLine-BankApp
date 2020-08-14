/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import java.util.ArrayList;

/**
 *
 * @author Felix
 */
public class Bank {
ArrayList<Customer>customers= new ArrayList<Customer>();
    void addCustomer(Customer customer) {
        customers.add(customer);
    }

   
    ArrayList<Customer> getCustomers(){
        return customers;
    }

    Customer getCustomer(int account) {
        return customers.get(account);
    }
}



