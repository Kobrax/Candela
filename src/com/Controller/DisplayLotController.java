package com.Controller;

import com.Model.DisplayLot;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by MazurJestBoski on 2016-05-20.
 */
public class DisplayLotController {

    DisplayLot displayLot = new DisplayLot();//creating displayLot object so we could use methods implemented in
                                            //DisplayLot class


    public ArrayList lotInfo(String lotNumber)
    {
        return displayLot.fullLotInfo(lotNumber);
    }



    public void saveToDB(String lotNumber, String realEstateRegister, Double area, String geodeticRegion,
                         String identificationNumber, String typeOfLot, String adress, String cadastralUnit,
                         String description, String loggedUser){
        displayLot.writeToDB(lotNumber, realEstateRegister, area, geodeticRegion,
                identificationNumber, typeOfLot, adress, cadastralUnit, description, loggedUser);
    }

    public void deleteFromDB(String table, int ID)
    {
        displayLot.deleteFromDB(table, ID);
    }

    public void updateDB(String lotNumber, String realEstateRegister, Double area, String geodeticRegion,
                         String identificationNumber, String typeOfLot, String adress, String cadastralUnit,
                         String description, String loggedUser, int lotID)
    {
        displayLot.updateInDB(lotNumber, realEstateRegister, area, geodeticRegion, identificationNumber,
                typeOfLot, adress, cadastralUnit, description, loggedUser, lotID);
    }

}


