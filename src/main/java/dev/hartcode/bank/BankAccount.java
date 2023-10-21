package dev.hartcode.bank;

import dev.hartcode.dto.Transaction;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankAccount {
    public enum BankType {
        CHECKING_ACCOUNT, SAVINGS_ACCOUNT
    }
    private final BankType bankType;
    private double balance;
    private final Map<Long, Transaction> transactions;

    public BankAccount(BankType bankType, double balance){
        this.bankType = bankType;
        this.balance = balance;
        transactions = new LinkedHashMap<>();
    }

    // Get a map of transaction IDs and their corresponding transaction details.
    public Map<Long, String> getTransactions() {
        Map<Long, String> txMap = new LinkedHashMap<>();
        for (var tx : transactions.entrySet()) {
            txMap.put(tx.getKey(), tx.getValue().toString());
        }
        return txMap;
    }

    // Get the type of the bank account.
    public BankType getBankType(){
        return bankType;
    }

    // Get the current balance of the bank account.
    public double getBalance() {
        return balance;
    }

    // Commit a transaction, updating the balance and adding it to the transaction history.
    void commitTransaction(int routingNumber, String customerID, long transactionID, double transactionAmount){
        balance += transactionAmount;
        transactions.put(transactionID, new Transaction(routingNumber, Integer.parseInt(customerID), transactionID, transactionAmount));
    }

    @Override
    public String toString() {
        return "Account: %s\nBalance: $%.2f\n".formatted(bankType.toString().replace("_"," "), balance);
    }
}
