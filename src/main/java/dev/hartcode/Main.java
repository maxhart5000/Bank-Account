package dev.hartcode;

import dev.hartcode.bank.Bank;
import dev.hartcode.bank.BankAccount;
import dev.hartcode.bank.BankCustomer;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a bank instance with an ID.
        Bank myBank = new Bank(134563);

        // Add customers with their names, initial balance, and overdraft limits.
        myBank.addCustomer("Max Hart", 1000, 10_000);
        myBank.addCustomer("Bruce Hart", 5000, 100_000);

        // Get customer IDs using their names.
        String maxId = myBank.getCustomerId("Max Hart");
        String bruceId = myBank.getCustomerId("Bruce Hart");

        // Get customer objects using their IDs.
        BankCustomer max = myBank.getCustomer(maxId);
        BankCustomer bruce = myBank.getCustomer(bruceId);

        // Print customer information.
        System.out.println(max);
        System.out.println(bruce);

        // Get lists of customer accounts.
        List<BankAccount> maxAccounts = max.getAccounts();
        List<BankAccount> bruceAccounts = bruce.getAccounts();

        // Perform transactions for Max.
        myBank.doTransaction(maxId, BankAccount.BankType.CHECKING_ACCOUNT, 1000);
        myBank.doTransaction(maxId, BankAccount.BankType.CHECKING_ACCOUNT, 500);
        myBank.doTransaction(maxId, BankAccount.BankType.SAVINGS_ACCOUNT, -100000);
        myBank.doTransaction(maxId, BankAccount.BankType.SAVINGS_ACCOUNT, 8000);
        myBank.doTransaction(maxId, BankAccount.BankType.SAVINGS_ACCOUNT, 6000);

        // Perform transactions for Bruce.
        myBank.doTransaction(bruceId, BankAccount.BankType.SAVINGS_ACCOUNT, 2000);
        myBank.doTransaction(bruceId, BankAccount.BankType.CHECKING_ACCOUNT, 8000);
        myBank.doTransaction(bruceId, BankAccount.BankType.SAVINGS_ACCOUNT, 4000);

        // Print updated customer information.
        System.out.println(max);
        System.out.println(bruce);

        // Create a list to store transaction details.
        List<String> transactionList = new LinkedList<>();

        // Collect transaction details from Max's accounts.
        for (BankAccount account : maxAccounts) {
            account.getTransactions().forEach((k, v) -> transactionList.add(v));
        }

        // Collect transaction details from Bruce's accounts.
        for (BankAccount account : bruceAccounts) {
            account.getTransactions().forEach((k, v) -> transactionList.add(v));
        }

        // Separator for readability.
        System.out.println("-".repeat(30));

        // Print all transaction details.
        transactionList.forEach(System.out::println);

        // Separator for readability.
        System.out.println("-".repeat(30));

        // Print transactions for Max's accounts.
        myBank.getCustomer(maxId).getAccounts().forEach(a -> a.getTransactions().values().forEach(System.out::println));
    }
}
