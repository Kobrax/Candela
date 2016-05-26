package com.Model;

import java.sql.*;

/**
 * Created by Dom on 2016-05-13.
 */
public class LoginModel {
    public static Connection conn = null;
    public String loggedUser = null;
    public boolean logged = false;
    public int lAdmin;

    public void connectToDB(){
        try
        {
            String DB_URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7119030";
            String USER = "sql7119030";
            String PASS = "ira72lBrrp";
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("conn obj created "+conn + " message: ");


        } catch (SQLException e)
        {
            System.out.println("db error"+e.getMessage());
        }
    }

    //made by Adam
    public boolean logIn(String userName, String password){
        String dbUsername, dbPassword;
        int dbAdmin;
        boolean logged = false;

        try
        {
            String sql ="SELECT userName, password, isAdmin FROM users";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                dbUsername = rs.getString("userName");
                dbPassword = rs.getString("password");
                dbAdmin = rs.getInt("isAdmin");

                if(userName.equals(dbUsername)&& password.equals(dbPassword))
                {
                    loggedUser = dbUsername;
                    logged = true;
                    lAdmin = dbAdmin;
                }
            }

        } catch(SQLException e)
        {
            e.printStackTrace();
        }
        return logged;
    }
}
