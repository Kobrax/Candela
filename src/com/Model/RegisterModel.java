package com.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by MazurJestBoski on 2016-05-18.
 */
public class RegisterModel {
    private static Connection conn = LoginModel.conn;


    public void registerUser(String userName, String password, String email, String livingArea, String name, String surname){

        String sql="INSERT INTO users VALUES (null, ?, ?, ?, ?, ?, ?, 0)";

        try
        {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, livingArea);
            preparedStatement.setString(5, name);
            preparedStatement.setString(6, surname);
            int numberOfRows= preparedStatement.executeUpdate();
            System.out.println("Completed insert. Number of rows affected:"+numberOfRows);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }



}
