package com.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Dom on 2016-05-26.
 */
public class EditUserModel {
    private static Connection conn = LoginModel.conn;


    public void updateUser(String userName, String password, String email, String livingArea, String name, String surname)
    {
        String sql="UPDATE users SET password = ?, email = ?, livingArea = ?, name = ?, surname = ? WHERE username = ?";

        try
        {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, livingArea);
            preparedStatement.setString(4, name);
            preparedStatement.setString(5, surname);
            preparedStatement.setString(6, userName);

            int numberOfRows= preparedStatement.executeUpdate();
            System.out.println("Completed update. Number of rows affected:"+numberOfRows);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
