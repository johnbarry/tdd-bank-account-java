package org.xpdojo.bank;

public class Account {
    private int balance;
    public static Account emptyAccount() {
        return new Account();
    }
    public Account() {
        balance = 0;
    }
    public int balance() {
        return balance;
    }

    public Account deposit(int amount) {
        balance += amount;
        return this;
    }

    public Account withdraw(int amount) throws IntoOverdraftException {
        if (amount > balance) {
            throw new IntoOverdraftException(balance, amount);
        }
        balance -= amount;
        return this;
    }
}
