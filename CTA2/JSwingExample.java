package CTA2;
import javax.swing.*;

public class JSwingExample {
    public static void main(String[] args) {
        // Create a new JFrame 
        JFrame frame = new JFrame("Simple GUI Example");

        // Set the size of the frame
        frame.setSize(400, 300);

        // Set the default close operation to exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new JPanel 
        JPanel panel = new JPanel();

        // Create a label and add it to the panel
        JLabel label = new JLabel("Welcome to my GUI application!");
        panel.add(label);

        // Create a button 
        JButton button = new JButton("Click Me!");
        // add it to the panel
        panel.add(button);

        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
