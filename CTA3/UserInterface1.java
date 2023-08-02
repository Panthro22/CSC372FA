package CTA3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
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
        StackPane pane = new StackPane(); // StackPane is a container that stacks its children on top of each other
        background = new Rectangle();
        background.setFill(Color.WHITE);

        background.widthProperty().bind(pane.widthProperty());//binds the width of the background to the width of the pane
        background.heightProperty().bind(pane.heightProperty());//binds the height of the background to the height of the pane
    
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

            menuItem1.setOnAction(e -> printDateTime());//Lambda expression
            menuItem2.setOnAction(e -> writeToLog());
            menuItem3.setOnAction(e -> changeBackgroundColor());
            menuItem4.setOnAction(e -> System.exit(0));

            this.getMenus().add(menu);
        }
    }

    private void printDateTime() {
    // Get the current date and time
    LocalDateTime currentDateTime = LocalDateTime.now();

    // Create a DateTimeFormatter to format the date and time
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-uuuu hh:mm:ss a");

    // Format the current date and time as a string
    String formattedDateTime = currentDateTime.format(formatter);

    //Formatted date and time into the text box
    textBox.setText(formattedDateTime);
}

    private void writeToLog() {
        // Code to write the text box contents to "log.txt"
    }

    private void changeBackgroundColor() {
        double hue = Math.random() * 360; // Generate a random hue value between 0 and 360 (full color range)
        background.setFill(Color.hsb(hue, 1.0, 1.0));
    }
}
