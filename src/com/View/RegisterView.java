package com.View;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by Dom on 2016-05-17.
 */
public class RegisterView {
    public void start()
    {
        BorderPane borderPane = new BorderPane();
        Stage stage = new Stage();
        Scene scene = new Scene(borderPane, 700,700);
        stage.setScene(scene);
        stage.show();
    }
}
