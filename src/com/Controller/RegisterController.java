package com.Controller;

import com.Model.LoginModel;
import com.Model.RegisterModel;
import com.View.LoginView;
import com.View.RegisterView;

/**
 * Created by MazurJestBoski on 2016-05-18.
 */
public class RegisterController {

    private RegisterModel registerModel = new RegisterModel();


    //METHOD WHICH PASSES THE INPUT FROM THE VIEW TO THE MODEL
    public void registerUser(String userName, String password, String email, String livingArea, String name, String surname) {
        try {
            registerModel.registerUser(userName, password, email, livingArea, name, surname);

        } catch (Exception e) {
            System.out.println("Exception in registerUser() from Controller: " + e.getMessage());
        }
    }
}
