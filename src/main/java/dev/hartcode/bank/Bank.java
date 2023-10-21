package dev.hartcode.bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final int routingNumber;
    private long lastTransactionID = 1;
    private Map<String, BankCustomer> customers;

    public Bank(int routingNumber){
        this.routingNumber = routingNumber;
        customers = new HashMap<>();
    }

    // Get customer ID by name.
    public String getCustomerId(String name){
        for (BankCustomer customer : customers.values()) {
            if (customer.getName().equals(name)) {
                return String.valueOf(customer.getId());
            }
        }
        System.out.println(name + " does not have an account with us.");
        return null;
    }

    // Get a customer by ID.
    public BankCustomer getCustomer(String id) {
        return customers.get(id);
    }

    public int getRoutingNumber(){
        return routingNumber;
    }

    // Add a new customer with initial deposits for checking and savings accounts.
    public void addCustomer(String name, double checkingInitialDeposit, double savingsInitialDeposit){
        BankCustomer newCustomer = new BankCustomer(name, checkingInitialDeposit, savingsInitialDeposit);
        customers.put(newCustomer.getId(), newCustomer);
    }

    // Perform a transaction for a customer's account.
    public boolean doTransaction(String id, BankAccount.BankType type, double amount){
        BankCustomer customer = customers.get(id);
        if (customer != null) {
            BankAccount account = customer.getAccounts(type);
            if (account != null) {
                if ((account.getBalance() + amount) >= 0) {
                    account.commitTransaction(routingNumber, id, lastTransactionID++, amount);
                    return true;
                } else {
                    System.out.println("Insufficient funds for customer: " + id);
                }
            } else {
                System.out.println("There is no corresponding account with this customer id");
            }
        } else {
            System.out.println("Invalid customer id");
        }
        return false;
    }
}
