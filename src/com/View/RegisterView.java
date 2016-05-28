package com.View;

import com.Controller.LoginController;
import com.Controller.RegisterController;
import com.Controller.ViewController;
import com.Model.RegisterModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by Dom on 2016-05-17.
 */
public class RegisterView {
    ViewController viewController = new ViewController();
    private RegisterController registerController = new RegisterController();

    public void start() {
        Stage stage = new Stage();
        GridPane gridPane = new GridPane();
        BorderPane borderPane = new BorderPane();
        HBox exitAndRegister = new HBox();
        borderPane.setCenter(gridPane);             //puttin gridpanee inside borderpane
        borderPane.setBottom(exitAndRegister);
        Text scenetitle = new Text("CANDELA DB");
        scenetitle.setFont(Font.font("Verdana", FontWeight.NORMAL, 35));
        gridPane.setPadding(new Insets(0, 0, 50, 0));
        borderPane.setId("backgroundImage");
        gridPane.setVgap(20);
        gridPane.setHgap(-80);

        Scene scene = new Scene(borderPane, 700, 700);
        stage.setScene(scene);


        Label errorLabel = new Label("");//////////////////BY ADAM/////////////////
        errorLabel.setStyle("-fx-font-size: 15;-fx-text-fill: crimson;-fx-font-weight:bold;");
        Label userLabel = new Label("User");
        userLabel.setStyle("-fx-font-size: 20");
        final TextField userField = new TextField();
        userField.setStyle("-fx-font-size: 16");

        Label passwordLabel = new Label("Password");
        passwordLabel.setStyle("-fx-font-size: 20");
        final TextField passwordText = new TextField();
        passwordText.setStyle("-fx-font-size: 16");

        Label nameLabel = new Label("Name");
        nameLabel.setStyle("-fx-font-size: 20");
        final TextField nameField = new TextField();
        nameField.setStyle("-fx-font-size: 16");

        Label surnameLabel = new Label("Surname");
        surnameLabel.setStyle("-fx-font-size: 20");
        final TextField surnameField = new TextField();
        surnameField.setStyle("-fx-font-size: 16");

        Label lAreaLabel = new Label("Living Area");
        lAreaLabel.setStyle("-fx-font-size: 20");
        final TextField lAreaField = new TextField();
        lAreaField.setStyle("-fx-font-size: 16");

        Label emailLabel = new Label("Email");
        emailLabel.setStyle("-fx-font-size: 20");
        final TextField emailField = new TextField();
        emailField.setStyle("-fx-font-size: 16");

        Button exit = new Button("Back");
        Button register = new Button("Register");
        exit.setStyle("-fx-min-width: 80px;\n" +
                "    -fx-max-width: 100px;\n" +
                "    -fx-background-color:\n" +
                "            #000000,\n" +
                "            #984639;\n" +
                "    -fx-background-insets: 0,1,2,3;\n" +
                "    -fx-background-radius: 3,2,2,2;\n" +
                "    -fx-padding: 12 30 12 30;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-font-size: 10px;");
        register.setStyle("-fx-min-width: 130px;\n" +
                "    -fx-max-width: 130px;\n" +
                "    -fx-background-color:\n" +
                "            #000000,\n" +
                "            #984639;\n" +
                "    -fx-background-insets: 0,1,2,3;\n" +
                "    -fx-background-radius: 3,2,2,2;\n" +
                "    -fx-padding: 12 30 12 30;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-font-size: 12px;");

        //locating the text fields and labels in gridPane

        exitAndRegister.getChildren().addAll(exit);
        GridPane.setConstraints(scenetitle, 0, 0);
        GridPane.setConstraints(userLabel, 0, 2);
        GridPane.setConstraints(userField, 1, 2);
        GridPane.setConstraints(passwordLabel, 0, 3);
        GridPane.setConstraints(passwordText, 1, 3);
        GridPane.setConstraints(nameLabel, 0, 4);
        GridPane.setConstraints(nameField, 1, 4);
        GridPane.setConstraints(surnameLabel, 0, 5);
        GridPane.setConstraints(surnameField, 1, 5);
        GridPane.setConstraints(lAreaLabel, 0, 6);
        GridPane.setConstraints(lAreaField, 1, 6);
        GridPane.setConstraints(emailLabel, 0, 7);
        GridPane.setConstraints(emailField, 1, 7);
        GridPane.setConstraints(register, 1, 8);
        GridPane.setConstraints(errorLabel, 1, 9);

        gridPane.setAlignment(Pos.CENTER);


        gridPane.getChildren().addAll(scenetitle, errorLabel, userLabel, userField, passwordLabel, passwordText, nameLabel, nameField, surnameLabel, surnameField, lAreaLabel, lAreaField, emailLabel, emailField, register);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage.setResizable(true);
        stage.show();

        register.setOnAction(event -> {
            String userName = nameField.getText();
            String password = passwordText.getText();
            String email = emailField.getText();
            String area = lAreaField.getText();
            String name = nameField.getText();
            String surname = surnameField.getText();
            if(userName.equals("") || password.equals("") || email.equals("") || area.equals("") || name.equals("") || surname.equals(""))
                errorLabel.setText("FILL ALL THE FIELDS!");
            else
            {
            registerController.registerUser(userName, password, email, area, name, surname);
            viewController.startLogin();
            stage.close();}
        });

        exit.setOnAction(event -> {
            viewController.startLogin();
            stage.close();
        });
    }
}
