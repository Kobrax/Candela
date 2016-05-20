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
                    String x =result.getString(i);
                    lotInfos.add(x);
                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return lotInfos;
    }


}
