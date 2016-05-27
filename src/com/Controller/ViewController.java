package com.Controller;

import com.View.*;

/**
 * Created by Dom on 2016-05-17.
 */
public class ViewController {


    //////CONTROLLER CLASS CREATED TO CONTAIN ALL OF THE STAGES START METHODS IN ONE PLACE/////////

    public void startMenu(String loggedUser)        //opening main menu
    {
        MenuView menuView = new MenuView();
        menuView.start(loggedUser);
    }

    public void startRegister()         //opening register window
    {
        RegisterView registerView = new RegisterView();
        registerView.start();
    }

    public void startLogin(){       //starting login window(the first visible stage)
        LoginView loginView = new LoginView();
        loginView.start();
    }
    public void browser()       //opens the window that lets you view the map
    {
        BrowserView browserView = new BrowserView();
        browserView.start();
    }

    public void editUser(String loggedUser)     //opens the stage in which you can edit your account details
    {
        EditView editView = new EditView();
        editView.start(loggedUser);
    }

    public void startCompare(String loggedUser)     //starts the compare window
    {
        CompareView compareView = new CompareView();
        compareView.start(loggedUser);
    }


}
