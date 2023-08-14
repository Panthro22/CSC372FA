package CTA2;

import CTA1.CheckingAccount;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

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
     public static void main(String[] args) {// Create a new thread to run the GUI
        SwingUtilities.invokeLater(() -> { // Use a lambda expression to create a new Runnable object. SwingUtilities.invokeLater() takes a Runnable object as an argument and runs it on the Event Dispatch Thread.
            BankGUI app = new BankGUI();
            app.setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depositButton) { // If the deposit button is clicked
            try {
                double amount = Double.parseDouble(amountField.getText());
                if (amount > 0) { // Check if the entered amount is positive
                checkingAccount.deposit(amount);
                balanceLabel.setText("Balance: $" + formatAmount(checkingAccount.getBalance()));
                amountField.setText("");
            } else {
                showErrorAlert("Please enter a positive amount.");
            }
            } catch (NumberFormatException ex) {// If the input is not a number
                showErrorAlert("Invalid input. Please enter a valid number amount.");
            }// else if established for later button additions
        } else if (e.getSource() == withdrawButton) {// If the withdraw button is clicked
            try {
                double amount = Double.parseDouble(amountField.getText());
                checkingAccount.processWithdrawal(amount);
                balanceLabel.setText("Balance: $" + formatAmount(checkingAccount.getBalance()));
                amountField.setText("");
                
            } catch (NumberFormatException ex) {// If the input is not a number
                showErrorAlert("Invalid input. Please enter a valid number amount.");
            }
        }

    }

    private void showErrorAlert(String message) {// Displays an error alert
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    private String formatAmount(double amount) {// Formats the amount to two decimal places for american currency
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        return decimalFormat.format(amount);
    }
}
