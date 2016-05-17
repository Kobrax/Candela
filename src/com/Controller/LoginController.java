package com.Controller;

import com.Model.LoginModel;
import com.View.LoginView;

/**
 * Created by MazurJestBoski on 2016-05-13.
 */
public class LoginController {

    LoginView loginView = new LoginView();
    LoginModel loginModel = new LoginModel();


    public void startLoginWindow(){
        LoginView loginView = new LoginView();
        loginView.start();
    }
}
