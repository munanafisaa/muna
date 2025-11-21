package modul_8.praktikum3;

public class BankAccount {
    // Private fields - hidden from outside world
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String password;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double initialBalance, String password) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.password = password;
    }

    // Public method - interface to the outside world
    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
            logTransaction("DEPOSIT", amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public boolean withdraw(double amount, String inputPassword) {
        if (authenticate(inputPassword)) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Successfully withdrawn: " + amount);
                logTransaction("WITHDRAW", amount);
                return true;
            } else {
                System.out.println("Invalid withdraw amount or insufficient funds");
            }
        } else {
            System.out.println("Authentication failed!");
        }
        return false;
    }

    public boolean transfer(BankAccount recipient, double amount, String inputPassword) {
        if (authenticate(inputPassword)) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                recipient.deposit(amount);
                System.out.println("Transfer successful to: " + recipient.getAccountNumber());
                logTransaction("TRANSFER TO: " + recipient.getAccountNumber(), amount);
                return true;
            }
        }
        return false;
    }

    // Private method - hidden implementation detail
    private boolean authenticate(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    // Protected method - visible to subclasses
    protected void applyInterest(double rate) {
        double interest = balance * rate;
        balance += interest;
        System.out.println("Interest applied: " + interest);
    }

    protected void logTransaction(String type, double amount) {
        System.out.println("[LOG] => Type: " + type + ", Amount: " + amount + ", New Balance: " + balance);
    }

    // Public method: shows account info (without sensitive data)
    public void displayAccountInfo() {
        System.out.println("--------------------");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("--------------------");
    }
}
