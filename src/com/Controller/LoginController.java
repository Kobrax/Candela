package com.Controller;

import com.Model.LoginModel;
import com.View.LoginView;
import com.View.MenuView;

/**
 * Created by MazurJestBoski on 2016-05-13.
 */
public class LoginController {

    LoginModel loginModel = new LoginModel();
    public int ladmin = loginModel.lAdmin;


    public boolean logIn(String userName, String password)
    {
        return loginModel.logIn(userName, password);

    }
    public boolean isAdmin(String userName)
    {
        return loginModel.isAdmin(userName);
    }

}
