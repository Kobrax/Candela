package com.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public void deleteUser(String table, int id) {        //method used to delete entries from DB
        String sql = "DELETE FROM users WHERE idUsers = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("Completed delete. Number of rows affected:" + numberOfRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList fullUserInfo(String userName) {  //returns all the properties of concrete lot in arraylist
        ArrayList<String> userInfos = new ArrayList<>();

        String sql = "SELECT userName, password, email, livingArea, name, surname FROM users WHERE userName = ?";

        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userName);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                for (int i = 1; i < 7; i++) {
                    String x = result.getString(i);
                    userInfos.add(x);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userInfos;
    }

}
