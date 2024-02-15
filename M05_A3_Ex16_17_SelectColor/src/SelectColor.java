/**
* Assignment: SDEV200_M05_A3_Ex16_17
* File: SelectColor.java
* Version: 1.0
* Date: 2/14/2024
* Author: Tomomi Hobara
* Description: This program displays a text and uses scrollbars to change its color and opacity.
* Variables: 
    - text: Text object for displaying text
    - sbRed, sbGreen, sbBlue: Scrollbars for adjusting the text color
    - textColor: Color object created by getting values from the Scrollbar  
* Steps:
     1. Create and format a Text object
     2. Create Scrollbar objects and set their value ranges
     3. Define a method to change the text color
     4. Set up event handlers to invoke the method everytime Scrollbars are moved
     5. Display the stage with all the components in it
  
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class SelectColor extends Application {
    // Declare data fields
    private Text text;
    private ScrollBar sbRed;
    private ScrollBar sbGreen;
    private ScrollBar sbBlue;
    private ScrollBar sbOpacity;

    @Override  // Override the start method in the Application class
    public void start (Stage primaryStage) {
        
        // Create and format a Text (p.553, 569)
        text = new Text ("Show Colors");
        text.setFont(new Font(32));
        text.setFill(new Color(0.0, 0.0, 0.0, 1.0));  // Set the default color to black with full opacity

        // Create a pane to display text
        StackPane paneForText = new StackPane();
        paneForText.getChildren().add(text);
        paneForText.setAlignment(Pos.CENTER);
        paneForText.setPadding(new Insets(25, 25, 25, 25));

        // Create Labels for Scrollbars
        Label lblRed = new Label("Red");
        Label lblGreen = new Label("Green");
        Label lblBlue = new Label("Blue");
        Label lblOpacity = new Label("Opacity");

        // Format Labels
        lblRed.setFont(new Font(24));
        lblGreen.setFont(new Font(24));
        lblBlue.setFont(new Font(24));
        lblOpacity.setFont(new Font(24));

        // Create ScrollBars
        sbRed = new ScrollBar();
        sbGreen = new ScrollBar();
        sbBlue = new ScrollBar();
        sbOpacity = new ScrollBar();

        // Set the range of values for the Scrollbars
        sbRed.setMin(0.0);
        sbRed.setMax(1.0);
        sbGreen.setMin(0.0);
        sbGreen.setMax(1.0);
        sbBlue.setMin(0.0);
        sbBlue.setMax(1.0);
        sbOpacity.setMin(0.0);
        sbOpacity.setMax(1.0);

        // Set the initial value for the opacity Scrollbar (fully opaque)
        sbOpacity.setValue(1.0);

        // Set the size of Scrollbars
        sbRed.setPrefHeight(20); 
        sbGreen.setPrefHeight(20);
        sbBlue.setPrefHeight(20);
        sbOpacity.setPrefHeight(20);
        sbRed.setPrefWidth(120); 
        sbGreen.setPrefWidth(120);
        sbBlue.setPrefWidth(120);
        sbOpacity.setPrefWidth(120);

        
        // Create a GridPane to display Scrollbars and Labels
        GridPane paneForScrollBar = new GridPane();

        // Define how Scrollbars and Labels will be positioned in the GridPane
        paneForScrollBar.setAlignment(Pos.CENTER);
        paneForScrollBar.setPadding(new Insets(25, 25, 25, 25));
        paneForScrollBar.setHgap(15);
        paneForScrollBar.setVgap(5);

        // Place labels and scrollbars in GridPane
        paneForScrollBar.add(lblRed, 0, 0);
        paneForScrollBar.add(sbRed, 1, 0);
        paneForScrollBar.add(lblGreen, 0, 1);
        paneForScrollBar.add(sbGreen, 1, 1);
        paneForScrollBar.add(lblBlue, 0, 2);
        paneForScrollBar.add(sbBlue, 1, 2);
        paneForScrollBar.add(lblOpacity, 0, 3);
        paneForScrollBar.add(sbOpacity, 1, 3);


        // Create event handlers for Scrollbars to change the color of the text, p618
        sbRed.valueProperty().addListener(ov -> changeColor());
        sbGreen.valueProperty().addListener(ov -> changeColor());
        sbBlue.valueProperty().addListener(ov -> changeColor());
        sbOpacity.valueProperty().addListener(ov -> changeColor());


        // Create a VBox to stack the two panes vertically
        VBox root = new VBox();
        root.getChildren().addAll(paneForText, paneForScrollBar);

        // Create a scene and place it in the stage
        Scene scene = new Scene(root, 350, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise16_17");
        primaryStage.show();

    }


    public void changeColor() {

        // Get values from the Scrollbars
        double r = sbRed.getValue();
        double g = sbGreen.getValue();
        double b = sbBlue.getValue();
        double o = sbOpacity.getValue();

        // Create a Color object
        Color textColor = new Color(r, g, b, o);
        text.setFill(textColor);  
    }

    
    public static void main (String[] args) {
        Application.launch(args);
    }
}
