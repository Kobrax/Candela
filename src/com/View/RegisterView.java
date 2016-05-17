package com.View;

import com.Controller.LoginController;
import com.Controller.ViewController;
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
    LoginController loginController = new LoginController();
    ViewController viewController = new ViewController();

    public void start()
    {
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

        Scene scene = new Scene(borderPane, 700,700);
        stage.setScene(scene);



        Label errorLabel = new Label("");//////////////////BY ADAM/////////////////
        errorLabel.setStyle("-fx-font-size: 15;-fx-text-fill: crimson;-fx-font-weight:bold;");
        Label user = new Label("User");
        user.setStyle("-fx-font-size: 20");
        final TextField userField = new TextField();
        userField.setStyle("-fx-font-size: 16");

        Label password = new Label("Password");
        password.setStyle("-fx-font-size: 20");
        final TextField passwordText = new TextField();
        passwordText.setStyle("-fx-font-size: 16");

        Label name = new Label("Name");
        name.setStyle("-fx-font-size: 20");
        final TextField nameField = new TextField();
        nameField.setStyle("-fx-font-size: 16");

        Label surname = new Label("Surname");
        surname.setStyle("-fx-font-size: 20");
        final TextField surnameField = new TextField();
        surnameField.setStyle("-fx-font-size: 16");

        Label lArea = new Label("Living Area");
        lArea.setStyle("-fx-font-size: 20");
        final TextField lAreaField = new TextField();
        lAreaField.setStyle("-fx-font-size: 16");

        Label email = new Label("Email");
        email.setStyle("-fx-font-size: 20");
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

        //locating the text fields and labels

        exitAndRegister.getChildren().addAll(exit);
        GridPane.setConstraints(scenetitle, 0, 0);
        GridPane.setConstraints(errorLabel, 0, 1);
        GridPane.setConstraints(user, 0, 2);
        GridPane.setConstraints(userField, 1, 2);
        GridPane.setConstraints(password,0,3);
        GridPane.setConstraints(passwordText,1,3);
        GridPane.setConstraints(name, 0, 4);
        GridPane.setConstraints(nameField, 1, 4);
        GridPane.setConstraints(surname, 0, 5);
        GridPane.setConstraints(surnameField, 1,5);
        GridPane.setConstraints(lArea, 0, 6);
        GridPane.setConstraints(lAreaField, 1, 6);
        GridPane.setConstraints(email, 0, 7);
        GridPane.setConstraints(emailField, 1, 7);


        GridPane.setConstraints(register, 1,8);

        gridPane.setAlignment(Pos.CENTER);


        gridPane.getChildren().addAll(scenetitle, errorLabel, user, userField, password, passwordText, name, nameField, surname, surnameField, lArea, lAreaField, email, emailField, register);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage.setResizable(true);
        stage.show();

        exit.setOnAction(event -> {
        loginController.startLoginWindow();
            stage.close();
        });
    }
}
