package com.Controller;

import com.View.LoginView;
import com.View.MenuView;
import com.View.RegisterView;

/**
 * Created by Dom on 2016-05-17.
 */
public class ViewController {
    public void startMenu(String loggedUser)
    {
        MenuView menuView = new MenuView();
        menuView.start(loggedUser);
    }

    public void startRegister()
    {
        RegisterView registerView = new RegisterView();
        registerView.start();
    }

    public void startLogin(){
        LoginView loginView = new LoginView();
        loginView.start();
    }
}
