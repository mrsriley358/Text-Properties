/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textproperties;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextProperties extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane pane = new GridPane();

        // Row 0
        TextField text = new TextField("Java Programming");
        Label lblTextField = new Label("Text Field:", text);
        lblTextField.setContentDisplay(ContentDisplay.RIGHT);

        HBox hBoxTop = new HBox(lblTextField);
        hBoxTop.setPadding(new Insets(2));

        hBoxTop.setAlignment(Pos.CENTER);
        pane.add(hBoxTop, 0, 0);

        // Row 1
        ToggleGroup group = new ToggleGroup();

        RadioButton rbLeft = new RadioButton();
        Label lblLeft = new Label("Left", rbLeft);
        rbLeft.setToggleGroup(group);
        rbLeft.setOnAction(e -> text.setAlignment(Pos.CENTER_LEFT));
        rbLeft.setSelected(true);

        RadioButton rbRight = new RadioButton();
        Label lblRight = new Label("Right", rbRight);

        rbRight.setOnAction(e-> text.setAlignment(Pos.CENTER_RIGHT));
        rbRight.setToggleGroup(group);

        RadioButton rbCenter = new RadioButton();
        Label lblCenter = new Label("Center", rbCenter);

        rbCenter.setOnAction(e-> text.setAlignment(Pos.CENTER));
        rbCenter.setToggleGroup(group);

        TextField columnSize = new TextField();
        columnSize.setPrefColumnCount(3);
        columnSize.setText("12");

        columnSize.setOnAction(e->
                text.setPrefColumnCount(Integer.parseInt(columnSize.getText())));
        Label lblColumnSize = new Label("Column Size", columnSize);
        lblColumnSize.setContentDisplay(ContentDisplay.RIGHT);

        HBox hBox = new HBox(lblLeft, lblCenter, lblRight, lblColumnSize);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(5, 5, 5, 5));
        pane.add(hBox, 0, 1);

        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Text Field Properties");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}