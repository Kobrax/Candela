package com.Controller;

import com.View.MenuView;
import com.View.RegisterView;

/**
 * Created by Dom on 2016-05-17.
 */
public class ViewController {
    public void startMenu()
    {
        MenuView menuView = new MenuView();
        menuView.start();
    }

    public void startRegister()
    {
        RegisterView registerView = new RegisterView();
        registerView.start();
    }
}
