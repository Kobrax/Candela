package com.View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by MazurJestBoski on 2016-05-13.
 */
public class MenuView {
    public void start() {
        Stage stage= new Stage();
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 700, 700);
        Button exit = new Button("Exit");
        borderPane.setBottom(exit);
        stage.setScene(scene);
        stage.show();

    }
}
