package com.Controller;

import com.Model.LoginModel;
import com.View.LoginView;
import com.View.MenuView;

/**
 * Created by MazurJestBoski on 2016-05-13.
 */
public class LoginController {

    LoginModel loginModel = new LoginModel();
    public int ladmin = 0;


    public void startLoginWindow(){
        LoginView loginView = new LoginView();
        loginView.start();
    }

    public int isAdmin()
    {
        ladmin = loginModel.lAdmin;
        return ladmin;
    }

    public boolean logIn(String userName, String password)
    {
        return loginModel.logIn(userName, password);
    }

}
