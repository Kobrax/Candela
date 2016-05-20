package com.Controller;

import com.Model.DisplayLot;

import java.util.ArrayList;

/**
 * Created by MazurJestBoski on 2016-05-20.
 */
public class DisplayLotController {

    DisplayLot displayLot = new DisplayLot();

    public ArrayList lotInfo(String lotNumber)
    {
        return displayLot.fullLotInfo(lotNumber);
    }
}


