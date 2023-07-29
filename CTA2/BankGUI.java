package CTA2;

import CTA1.BankAccount;
import CTA1.CheckingAccount;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankGUI extends JFrame implements ActionListener {
    private CheckingAccount checkingAccount;
    private JLabel balanceLabel;
    private JButton depositButton;
    private JButton withdrawButton;
    private JTextField amountField;

    public BankGUI() {
        checkingAccount = new CheckingAccount(); // Create a CheckingAccount instance
        checkingAccount.setAccountID(123456789); // Set the account number
        checkingAccount.setFirstName("John"); // Set the first name
        checkingAccount.setLastName("Rowly"); // Set the last name
        checkingAccount.setInterestRate(0.01); // Set the interest rate
        checkingAccount.deposit(1000.00); // Deposit $1000.00

        //Create a GUI Components
        balanceLabel = new JLabel("Balance: $" + checkingAccount.getBalance());
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        amountField = new JTextField(10);
        
        // Add action listeners
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);

        // Set up the layout
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(balanceLabel);
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);

        // Add the panel to the JFrame
        getContentPane().add(panel);

        // Set JFrame properties
        setTitle("All Legit Banking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Center the window on the screen
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }}
