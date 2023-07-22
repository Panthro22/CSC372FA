package CTA1;

public class TestCheckingAccount {
    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.setFirstName("Jill");
        checkingAccount.setLastName("Larsen");
        checkingAccount.setAccountID(123456789);
        checkingAccount.setInterestRate(0.15);
        
        checkingAccount.deposit(1500.0);
        checkingAccount.getBalance();
        
        checkingAccount.displayAccount();
        
        checkingAccount.processWithdrawal(200.0);
        checkingAccount.getBalance();
        checkingAccount.processWithdrawal(1450.0);
        checkingAccount.getBalance();
        checkingAccount.deposit(2530.0);
        checkingAccount.getBalance();
        checkingAccount.processWithdrawal(1450.0);
        checkingAccount.getBalance();
        
        checkingAccount.displayAccount();
    }
}