package com.View;


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


public class LoginView {



    public void start(){
        //LoginController loginController = new LoginController();

        //creating scene
        Stage primaryStage = new Stage();
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

        Scene scene = new Scene(borderPane,650,540);
        primaryStage.setScene(scene);


        Label errorLabel = new Label("");//////////////////BY MAZUR/////////////////
        errorLabel.setStyle("-fx-font-size: 15;-fx-text-fill: crimson;-fx-font-weight:bold;");
        Label user = new Label("User");
        user.setStyle("-fx-font-size: 20");
        TextField userField = new TextField();
        userField.setStyle("-fx-font-size: 16");
        Label password = new Label("Password");
        password.setStyle("-fx-font-size: 20");
        TextField passwordText = new TextField();
        passwordText.setStyle("-fx-font-size: 16");
        Button logIn = new Button("Log In");
        Button exit = new Button("Exit");
        Button register = new Button("Register");
        logIn.setStyle("-fx-min-width: 130px;\n" +
                "    -fx-max-width: 130px;\n" +
                "    -fx-background-color:\n" +
                "            #000000,\n" +
                "            #984639;\n" +
                "    -fx-background-insets: 0,1,2,3;\n" +
                "    -fx-background-radius: 3,2,2,2;\n" +
                "    -fx-padding: 12 30 12 30;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-font-size: 12px;");

        exit.setStyle("-fx-min-width: 80px;\n" +
                "    -fx-max-width: 80px;\n" +
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
        GridPane.setConstraints(scenetitle,0,0);
        GridPane.setConstraints(errorLabel,0,1);
        GridPane.setConstraints(user,0,2);
        GridPane.setConstraints(userField,1,2);
        GridPane.setConstraints(password,0,3);
        GridPane.setConstraints(passwordText,1,3);
        GridPane.setConstraints(logIn,1,4);
        GridPane.setConstraints(register, 1,5);

        gridPane.setAlignment(Pos.CENTER);


        gridPane.getChildren().addAll(scenetitle,errorLabel,user,userField,password,passwordText,logIn,register);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        primaryStage.setResizable(false);
        primaryStage.show();

    }




    }

