package com;

import com.Controller.LoginController;
import com.View.LoginView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by MazurJestBoski on 2016-05-13.
 */


public class Main extends Application {

        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController();


        public static void main(String[] args) {


            launch(args);
        }

        @Override
        public void start(Stage primaryStage) throws Exception {
            loginController.startLoginWindow();
        }
    }
