package CTA1;

public class CheckingAccount extends BankAccount {
    private double interestRate;

    public CheckingAccount() {
        super();
        this.interestRate = 0.05;
    }
    public void processWithdrawal(double amount) {
        double overdraftFee = 30.0;

        if (this.getBalance() >= amount) {
            this.withdrawal(amount);
        } else {
            this.withdrawal(amount + overdraftFee);
            System.out.println("Negative balance (including $30 overdraft fee): $" + (this.getBalance()));
            System.out.println("An overdraft fee of $30 has been assessed.");
        }
    }

    public void displayAccount() {
        super.accountSummary();
        System.out.println("Interest Rate: " + this.interestRate);
    }
}