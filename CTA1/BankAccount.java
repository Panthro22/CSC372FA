package CTA1;

public class BankAccount {
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;

    public BankAccount() {
        balance = 0.0;
    }
    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdrawal(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getAccountID() {
        return this.accountID;
    }

    public double getBalance() {
        return this.balance;
    }

    public void accountSummary() {
        System.out.println("Account Summary");
        System.out.println("Name: " + this.firstName + " " + this.lastName);
        System.out.println("Account ID: " + this.accountID);
        System.out.println("Balance: " + this.balance);
    }
}