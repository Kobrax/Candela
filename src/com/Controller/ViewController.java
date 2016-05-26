package com.Controller;

import com.View.*;

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
    public void browser()
    {
        BrowserView browserView = new BrowserView();
        browserView.start();
    }

    public void editUser(String loggedUser)
    {
        EditView editView = new EditView();
        editView.start(loggedUser);
    }
}
