package com;

import com.Controller.LoginController;
import com.Controller.ViewController;
import com.Model.LoginModel;
import com.View.LoginView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by MazurJestBoski on 2016-05-13.
 */


public class Main extends Application {

    ViewController viewController = new ViewController();
    LoginModel loginModel = new LoginModel();


    public static void main(String[] args) {


        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        viewController.startLogin();
        loginModel.connectToDB();

    }
}
