package com.View;

import com.Controller.EditUserController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Created by Dom on 2016-05-26.
 */
public class EditView {
    public void start(String loggedUser) {
        EditUserController editUserController = new EditUserController();

        Stage stage = new Stage();
        BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();
        Button saveButton = new Button("Save");
        borderPane.setCenter(gridPane);
        Scene scene = new Scene(borderPane, 400, 350);
        borderPane.setPadding(new Insets(20, 20, 20, 20));
        BorderPane.setAlignment(gridPane, Pos.BASELINE_CENTER);

        Label userLabel = new Label(loggedUser);
        userLabel.setFont(new Font("Arial", 20));

        Label emptyLabel = new Label("Edit Account");
        emptyLabel.setFont(new Font("Arial", 20));

        TextField email = new TextField();
        Label emailLabel = new Label("Email: ");
        emailLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        TextField password = new TextField();
        Label passwordLabel = new Label("Password: ");
        passwordLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        TextField livingArea = new TextField();
        Label areaLabel = new Label("Living Area: ");
        areaLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        TextField name = new TextField();
        Label nameLabel = new Label("Name: ");
        nameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        TextField surname = new TextField();
        Label surnameLabel = new Label("Surname: ");
        surnameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        gridPane.setVgap(18);
        gridPane.setHgap(10);
        gridPane.addColumn(0, userLabel, emailLabel, passwordLabel, areaLabel, nameLabel, surnameLabel);
        gridPane.addColumn(1, emptyLabel, email, password, livingArea, name, surname, saveButton);

        borderPane.setId("backgroundImage");
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());


        saveButton.setOnAction(event ->
        {
            editUserController.editUser(loggedUser, password.getText(), email.getText(),
                    livingArea.getText(), name.getText(), surname.getText());
            stage.close();
        });

        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
}
