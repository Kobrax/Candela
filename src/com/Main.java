package com;

import com.View.LoginView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by MazurJestBoski on 2016-05-13.
 */


public class Main extends Application {

        LoginView loginView = new LoginView();
        //LoginViewController loginViewController = new LoginViewController();


        public static void main(String[] args) {

            launch(args);
        }

        @Override
        public void start(Stage primaryStage) throws Exception {
        }
    }
}
