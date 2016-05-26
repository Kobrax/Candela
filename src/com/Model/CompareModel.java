package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by MazurJestBoski on 2016-05-25.
 */
public class CompareModel {

    private static Connection conn;
    ArrayList<String> lotNumberList = new ArrayList<>();

    public ArrayList createLotNumberList(String loggedUs) {
        try {

            String DB_URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7119030";
            String USER = "sql7119030";
            String PASS = "ira72lBrrp";
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "SELECT lotNumber FROM lot WHERE username = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, loggedUs);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                    String x = result.getString(1);
                    lotNumberList.add(x);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Database problem123");

        }
        return lotNumberList;
    }
}
