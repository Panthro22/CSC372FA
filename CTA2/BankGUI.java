package CTA2;

import CTA1.BankAccount;
import CTA1.CheckingAccount;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankGUI extends JFrame implements ActionListener {
    private CheckingAccount checkingAccount;
    
    public BankGUI() {
        checkingAccount = new CheckingAccount(); // Create a CheckingAccount instance
        checkingAccount.setAccountID(123456789); // Set the account number
        checkingAccount.setFirstName("John"); // Set the first name
        checkingAccount.setLastName("Rowly"); // Set the last name
        checkingAccount.setInterestRate(0.01); // Set the interest rate
        checkingAccount.deposit(1000.00); // Deposit $1000.00
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }}
