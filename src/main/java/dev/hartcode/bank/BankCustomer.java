package dev.hartcode.bank;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
    private static int counter = 10_000_000;
    private final String name;
    private final int id;
    private final List<BankAccount> accounts;

    // Constructor to create a bank customer with a name and initial deposit for checking and savings accounts.
    BankCustomer(String name, double checkingInitialDeposit, double savingsInitialDeposit){
        this.name = name;
        this.id = counter++;
        accounts = new ArrayList<>(2);
        accounts.add(new BankAccount(BankAccount.BankType.CHECKING_ACCOUNT, checkingInitialDeposit));
        accounts.add(new BankAccount(BankAccount.BankType.SAVINGS_ACCOUNT, savingsInitialDeposit));
    }

    // Get the customer's name.
    public String getName() {
        return name;
    }

    // Get the customer's ID in a formatted string.
    public String getId() {
        return "%015d".formatted(id);
    }

    // Get an immutable list of the customer's accounts.
    public List<BankAccount> getAccounts() {
        return List.copyOf(accounts);
    }

    // Get a specific account based on its type (CHECKING_ACCOUNT or SAVINGS_ACCOUNT).
    public BankAccount getAccounts(BankAccount.BankType type){
        for (var account : accounts) {
            if (account.getBankType() == type) {
                return account;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (BankAccount account : accounts) {
            sb.append(account.toString());
        }
        return "Name: %s\nID: %d\n%s".formatted(name, id, sb);
    }
}
