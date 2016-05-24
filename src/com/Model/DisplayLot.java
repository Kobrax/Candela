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
                " identificationNumber, typeLot, adress, cadastralUnit, description FROM lot WHERE lotNumber = ?";

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


///////////////by Adam
    public void deleteFromDB(String table, int id)
    {
        String sql="DELETE FROM lot WHERE lotID = ?";
        try
        {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int numberOfRows= preparedStatement.executeUpdate();
            System.out.println("Completed delete. Number of rows affected:"+numberOfRows);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

/////////////By Adam
    public void updateInDB(String lotNumber, String realEstateRegister, Double area, String geodeticRegion,
                           String identificationNumber, String typeOfLot, String adress, String cadastralUnit, String description, String loggedUser, int lotID)
    {
        String sql="UPDATE lot SET lotNumber=?, realEstateRegister=?, area=?, geodeticRegion=?, identificationNumber=?, typeLot=?, adress=?, cadastralUnit=?, description=?, username=? WHERE lotID = ?";

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
            preparedStatement.setInt(11, lotID);
            int numberOfRows= preparedStatement.executeUpdate();
            System.out.println("Completed update. Number of rows affected:"+numberOfRows);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


}
