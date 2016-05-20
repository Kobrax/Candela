package com.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by MazurJestBoski on 2016-05-20.
 */
public class DisplayLot {

    private static Connection conn = LoginModel.conn;


    public ArrayList fullLotInfo(String lotNumber){
        ArrayList<String> lotInfos = new ArrayList<>();

        String sql = "SELECT lotNumber, realEstateRegister, area, geodeticRegion," +
                " identificationNumber, typeLot, adress, cadastralUnit, description FROM lot WHERE realEstateRegister = ?";

        try
        {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, lotNumber);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                for(int i = 1 ; i<10; i++) {
                    String x = result.getString(i);
                    lotInfos.add(x);
                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return lotInfos;
    }



    public void writeToDB(String lotNumber, String realEstateRegister, Double area, String geodeticRegion,
                          String identificationNumber, String typeOfLot, String adress, String cadastralUnit, String description, String loggedUser){



        String sql="INSERT INTO lot VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n";

        try
        {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, lotNumber);
            preparedStatement.setString(2, realEstateRegister);
            preparedStatement.setDouble(3, area);
            preparedStatement.setString(4, geodeticRegion);
            preparedStatement.setString(5, identificationNumber);
            preparedStatement.setString(6, typeOfLot);
            preparedStatement.setString(7, adress);
            preparedStatement.setString(8, cadastralUnit);
            preparedStatement.setString(9, description);
            preparedStatement.setString(10, loggedUser);

            int numberOfRows= preparedStatement.executeUpdate();

            System.out.println("Completed insert. Number of rows affected:" + numberOfRows);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


}
