package dev.hartcode.dto;

public class Transaction {
    private int routingNumber;
    private int customerID;
    private long transactionID;
    private double transactionAmount;

    // Constructor to initialize a transaction with specific details.
    public Transaction(int routingNumber, int customerID, long transactionID, double transactionAmount) {
        this.routingNumber = routingNumber;
        this.customerID = customerID;
        this.transactionID = transactionID;
        this.transactionAmount = transactionAmount;
    }

    // Getter for routing number.
    public int getRoutingNumber() {
        return routingNumber;
    }

    // Setter for routing number.
    public void setRoutingNumber(int routingNumber) {
        this.routingNumber = routingNumber;
    }

    // Getter for customer ID.
    public int getCustomerID() {
        return customerID;
    }

    // Setter for customer ID.
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    // Getter for transaction ID.
    public long getTransactionID() {
        return transactionID;
    }

    // Setter for transaction ID.
    public void setTransactionID(long transactionID) {
        this.transactionID = transactionID;
    }

    // Getter for transaction amount.
    public double getTransactionAmount() {
        return transactionAmount;
    }

    // Setter for transaction amount.
    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    // Override the toString method to format transaction details as a string.
    @Override
    public String toString() {
        return String.format("%05d:%05d:%05d:$%05.2f", routingNumber, customerID, transactionID, transactionAmount);
    }
}
