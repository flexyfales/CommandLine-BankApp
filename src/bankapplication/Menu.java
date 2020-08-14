/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Felix
 */
public class Menu {
Scanner keyboard = new Scanner(System.in);
     Bank bank =new Bank();
     boolean exit;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Menu menu =new Menu();
        menu.runMenu();
    }
     public void runMenu(){
        printHeader();
         
        while(!exit){
            printMenu();
            int choice =getInput();
            perfomAction(choice);
        }
    }

      private void printHeader() {
        System.out.println("|----------------------------------|");
        System.out.println("| Welcome To Felix Bank App       |");
        System.out.println("|---------------------------------|");
       
    }
      
       private void printMenu() {
        System.out.println("Please Make a Selection");
        System.out.println("1) Create Account");
        System.out.println("2) Make a deposit");
        System.out.println("3) Make a withdrawal");
        System.out.println("4) List account balance");
        System.out.println("0) Exit ");
    }

      
      
      
      
     
     private int getInput() {
        int choice=-1;
         do{ 
              System.out.print("Enter your choice");
        try{
            choice= Integer.parseInt(keyboard.nextLine());
            
          }catch(NumberFormatException e){
        
        System.out.println("Invalid Selection Numbers Only");
        
           }
        if(choice < 0|| choice > 4){
            System.out.println("Choice out of range choose again");
        }
         }while((choice < 0|| choice > 4));
         return choice;
 } 
     
     
   private void perfomAction(int choice) {
        switch(choice){
        case 0:
         System.out.println("Thank you for using our application");
          System.exit(0);
          break;
        case 1:
            createAccount();
            break;
        case 2:
            makeDeposit();
            break;
        case 3:
            makeWithdrawal();
            break;
        case 4:
            listbalances();
            break;
        default:
         System.out.println("Unkown error occured");
        }
    }   

    private void createAccount() {
        String firstName,lastName,ssn,accountType = null;
        double initialDeposit = 0;
        boolean valid=false;
        while(!valid){
            System.out.println("Please enter an account type savings/checkings");
            accountType=keyboard.nextLine();
            if(accountType.equalsIgnoreCase("Checking")|| accountType.equalsIgnoreCase("Savings")){
                valid=true;
            }else {
                System.out.println("Invalid account selected");
            }
        }
        System.out.println("Enter firstName");
        firstName=keyboard.nextLine();
        System.out.println("Enter lastName");
       lastName=keyboard.nextLine();
       System.out.println("Enter social security number");
       ssn=keyboard.nextLine();
       valid =false;
       while(!valid){
           System.out.println("Please enter initial Deposit");
           try{
               initialDeposit=Double.parseDouble(keyboard.nextLine());
           }catch(Exception e){
               System.out.println("Deposit must be a number");
           }
           if(accountType.equalsIgnoreCase("checking")){
               if(initialDeposit < 100){
                   System.out.println("Checking account require a minimum of 100 dollars");
               }else{
                   valid=true;
               }
           }else if(accountType.equalsIgnoreCase("savings")){
               if(initialDeposit < 50){
                   System.out.println("Savings account require a minimum of 50 dollars");
               }else{
                   valid=true;
               }
           }
       }
       Account account;
       if(accountType.equalsIgnoreCase("checking")){
           account=new Checking(initialDeposit);
       }else {
           account=new Savings(initialDeposit);
        }
       Customer customer =new Customer( firstName,  lastName, ssn,account);
       bank.addCustomer(customer);
    }

     private void makeDeposit() {
        int account=selectAccount();
        if(account >= 0) {
        System.out.println("How much would you like to deposit");
        double amount=0;
        try{
            amount=Double.parseDouble(keyboard.nextLine());
            
        }catch(NumberFormatException e){
            amount=0;
        }
        bank.getCustomer(account).getAccount().deposit(amount);
        }
    }
    private void makeWithdrawal() {
        int account=selectAccount();
        if(account >=0) {
        System.out.println("How much would you like to withdraw");
        double amount=0;
        try{
            amount=Double.parseDouble(keyboard.nextLine());
            
        }catch(NumberFormatException e){
            amount=0;
        }
        bank.getCustomer(account).getAccount().withdraw(amount);
        }
    }

    private void listbalances() {
         int account=selectAccount();
        if(account > 0) {
        System.out.println( bank.getCustomer(account).getAccount());
       
        }else{
            System.out.println("Invalid account selected");
        }
    }
 
    private int selectAccount() {
        ArrayList<Customer>customers = bank.getCustomers();
        if(customers.size() <= 0){
            System.out.println("No customers at your bank");
            return -1;
        }
        System.out.println("Select an account");
        for(int i=0;i < customers.size(); i++){
            System.out.println((i+1)+")" +customers.get(i).basicInfo());
        }
        int account=0;
        System.out.println("Please enter your selection");
         try{
            account=Integer.parseInt(keyboard.nextLine())-1;
            
        }catch(NumberFormatException e){
            account=-1;
        }
        if(account < 0 || account > customers.size()){
            account= -1;
        }
        return account ;
    }
     
     
     
}






































