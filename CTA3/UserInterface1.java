package CTA3;

import javafx.application.Application;
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
        StackPane pane = new StackPane();
        background = new Rectangle(400, 300);
        background.setFill(Color.WHITE);
        pane.getChildren().addAll(background, menuBar); // Add the MenuBar first
        StackPane.setAlignment(menuBar, javafx.geometry.Pos.TOP_CENTER);

        textBox = new TextField("Type here...");
        pane.getChildren().add(textBox); // Add the TextField later
        Scene scene = new Scene(pane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class MyMenuBar extends MenuBar {
        public MyMenuBar() {
            Menu menu = new Menu("File");

            MenuItem menuItem1 = new MenuItem("Print Date and Time");
            MenuItem menuItem2 = new MenuItem("Write to log.txt");
            MenuItem menuItem3 = new MenuItem("Change Background Color");
            MenuItem menuItem4 = new MenuItem("Exit");

            menu.getItems().addAll(menuItem1, menuItem2, menuItem3, menuItem4);

            menuItem1.setOnAction(e -> printDateTime());
            menuItem2.setOnAction(e -> writeToLog());
            menuItem3.setOnAction(e -> changeBackgroundColor());
            menuItem4.setOnAction(e -> System.exit(0));

            this.getMenus().add(menu);
        }
    }

    private void printDateTime() {
        // Code to print the date and time in a text box
    }

    private void writeToLog() {
        // Code to write the text box contents to "log.txt"
    }

    private void changeBackgroundColor() {
        double hue = Math.random() * 360; // Generate a random hue value between 0 and 360 (full color range)
        background.setFill(Color.hsb(hue, 1.0, 1.0));
    }
}
