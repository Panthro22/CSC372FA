package CTA3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class UserInterface1 extends Application {

    private boolean colorChanged = false;
    private Rectangle background;
    private TextField textBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("User Interface One");

        MyMenuBar menuBar = new MyMenuBar();
        StackPane pane = new StackPane();
        background = new Rectangle();
        background.setFill(Color.WHITE);

        background.widthProperty().bind(pane.widthProperty());//binds background to the width of the pane
        background.heightProperty().bind(pane.heightProperty());//binds background to the height of the pane
    
        pane.getChildren().addAll(background, menuBar); 
        StackPane.setAlignment(menuBar, javafx.geometry.Pos.TOP_CENTER);//aligns the menu bar to the top of the pane

        textBox = new TextField("Type here...");
        textBox.setMaxWidth(200);
        StackPane.setAlignment(textBox, Pos.CENTER_LEFT);
        pane.getChildren().add(textBox);
        Scene scene = new Scene(pane, 450, 225);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class MyMenuBar extends MenuBar {
        public MyMenuBar() {
            Menu menu = new Menu("File Menu");

            MenuItem menuItem1 = new MenuItem("Print Date and Time");
            MenuItem menuItem2 = new MenuItem("Write to log.txt");
            MenuItem menuItem3 = new MenuItem("Change Background Color");
            MenuItem menuItem4 = new MenuItem("Exit");

            menu.getItems().addAll(menuItem1, menuItem2, menuItem3, menuItem4);

            menuItem1.setOnAction(e -> printDateTime());//Lambda expression e is the event, -> is the arrow, printDateTime() is the method
            menuItem2.setOnAction(e -> writeToLog());
            menuItem3.setOnAction(e -> changeBackgroundColor());
            menuItem4.setOnAction(e -> handleExit());

            this.getMenus().add(menu);
        }
    }
    
    private void handleExit() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Exit Confirmation");
        alert.setHeaderText("Are you sure you want to exit?");
        alert.setContentText("Click OK to confirm and exit the program.");

        // Wait for the user's response
        Optional<ButtonType> result = alert.showAndWait();/* Optional is a container object which may or may not contain a non-null value. 
                                                             If a value is present, isPresent() will return true and get() will return the value.
                                                          */
        // If the user clicked OK, exit the program
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.exit(0);
        }
    }
    private void printDateTime() {
    // Get current date and time
    LocalDateTime currentDateTime = LocalDateTime.now();

    //formatted to standard non-military time
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-uuuu hh:mm:ss a");

    // Put date and time into a string
    String formattedDateTime = currentDateTime.format(formatter);

    // Formatted date and time into the text box
    textBox.setText(formattedDateTime);
    }

    private void writeToLog() {
        // Get the text from the textField
        String text = textBox.getText();
        
        // Check if the text is empty
        if (text.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Empty Text");
            alert.setContentText("The text is empty. Please enter some text before writing to log.txt.");
            alert.showAndWait();
            return; // Exit the method to prevent writing an empty log file
        }
        // Create a File object for "log.txt" in the same folder as the application
        File file = new File("log.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // Write the contents of the textField to the file
            writer.write(text);

            // Optional: Add a newline character at the end of the text
            writer.newLine();

            // Flush and close the writer
            writer.flush();
            writer.close();

            // Output confirmation message
            System.out.println("Text written to log.txt successfully!");
        } catch (IOException e) {
            // Handle any IO exceptions that may occur
            e.printStackTrace();
        }
    }

    private void changeBackgroundColor() {
        double randomColor = Math.random() * 360; // Get a random color
        background.setFill(Color.hsb(randomColor, 1.0, 1.0));
    }
}
