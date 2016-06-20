package com.Controller;


import com.Model.CompareModel;

import java.util.ArrayList;

/**
 * Created by MazurJestBoski on 2016-05-25.
 */
public class CompareController {
    CompareModel compareModel = new CompareModel();  //creating compareModel object so we could use methods implemented in
                                                    //CompareModel class

    public ArrayList createLotNumberList(String loggedUs){
        return compareModel.createLotNumberList(loggedUs);
    }

    public ArrayList createAdminLotNumberList(){
        return compareModel.createLotNumberListA();
    }

}