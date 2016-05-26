package com.Controller;

import com.Model.EditUserModel;

/**
 * Created by Dom on 2016-05-26.
 */
public class EditUserController {

    public void editUser(String userName, String password, String email, String livingArea, String name, String surname)
    {
        EditUserModel editUserModel = new EditUserModel();
        editUserModel.updateUser(userName, password, email, livingArea, name, surname);
    }


}
