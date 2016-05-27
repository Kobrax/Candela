package com.View;

import com.Controller.CompareController;
import com.Controller.DisplayLotController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Created by MazurJestBoski on 2016-05-25.
 */
public class CompareView {
    DisplayLotController displayLotController = new DisplayLotController();
    CompareController compareController = new CompareController();
    Button buttonBackCompare = new Button("Back");
    Label compareL, lotNumberL, realEstateRegisterL, areaL, geodeticRegionL,
            identificationNumberL, typeLotL, adressL, cadastralUnitL, optionalL, error;
    Scene sceneCompare;
    BorderPane layoutCompare;
    Stage stage;
    public void start(String loggedUser){
        stage = new Stage();
        layoutCompare = new BorderPane();
        VBox vBoxCompareLeft = new VBox(20);
        VBox vBoxlayoutCompareCenter = new VBox(20);
        VBox vBoxlayoutCompareRight = new VBox(20);
        HBox hBoxCompareBottom = new HBox();
        ComboBox comboCompare1 = new ComboBox();
        comboCompare1.getItems().addAll(compareController.createLotNumberList(loggedUser));
        ComboBox comboCompare2 = new ComboBox();
        comboCompare2.getItems().addAll(compareController.createLotNumberList(loggedUser));
        vBoxlayoutCompareCenter.getChildren().add(comboCompare1);
        vBoxlayoutCompareRight.getChildren().add(comboCompare2);
        buttonBackCompare.setOnAction(event ->
        {
            stage.close();
        });

        ///////adding names to labels and setting their font properties/////////
        compareL = new Label("Compare two lots:  \n");

        lotNumberL = new Label("Lot Number:              ");
        realEstateRegisterL = new Label("Real Estate Register:  ");
        areaL = new Label("Area:             ");
        geodeticRegionL = new Label("Geodetic Region:     ");
        identificationNumberL = new Label("Identification Number:  ");
        typeLotL = new Label("Lot Type:           ");
        adressL = new Label("Address:         ");
        cadastralUnitL = new Label("Cadastral Unit:        ");
        optionalL = new Label("Optional Info:         ");
        error = new Label("");
        lotNumberL.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        realEstateRegisterL.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        areaL.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        geodeticRegionL.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        identificationNumberL.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        typeLotL.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        adressL.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        cadastralUnitL.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        optionalL.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        error.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        compareL.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        /////////////////////////////////////////

        Button buttonCompare = new Button("Compare");
        buttonCompare.setOnAction(event1 -> {
            if(vBoxlayoutCompareCenter.getChildren().size()>1)//checks if there are some lot details already in labels, ignores comboBox
            {
                vBoxlayoutCompareCenter.getChildren().remove(1,10);      //if so it clears them so the new ones could appear
                vBoxlayoutCompareRight.getChildren().remove(1,10);
            }
            System.out.println(compareController.createLotNumberList(loggedUser));
            if(comboCompare1.getValue()!=null && comboCompare2.getValue()!=null){
                String lotNumber1 = comboCompare1.getValue().toString();
                String lotNumber2 = comboCompare2.getValue().toString();
                if (!lotNumber1.equals(lotNumber2)  ) {
                    for (int i = 0; i < 9; i++) {
                        Label lotUnit1 = new Label("");
                        Label lotUnit2 = new Label("");
                        String a = displayLotController.lotInfo(lotNumber1).get(i).toString();
                        String b = displayLotController.lotInfo(lotNumber2).get(i).toString();
                        lotUnit1.setText(a);
                        lotUnit2.setText(b);
                        lotUnit1.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        lotUnit2.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                        vBoxlayoutCompareCenter.getChildren().add(lotUnit1);
                        vBoxlayoutCompareRight.getChildren().add(lotUnit2);
                    }
                error.setText("");
                }
            else
                error.setText("         You need to choose 2 different lots!");
            }
            else
                error.setText("         You need 2 lots to compare!");
        });


        vBoxCompareLeft.getChildren().addAll(compareL, lotNumberL, realEstateRegisterL, areaL, geodeticRegionL, identificationNumberL, typeLotL, adressL, cadastralUnitL, optionalL);
        hBoxCompareBottom.getChildren().addAll(buttonBackCompare, buttonCompare, error);
        layoutCompare.setLeft(vBoxCompareLeft);
        layoutCompare.setCenter(vBoxlayoutCompareCenter);
        layoutCompare.setRight(vBoxlayoutCompareRight);
        layoutCompare.setBottom(hBoxCompareBottom);

        sceneCompare = new Scene(layoutCompare, 600, 400);
        stage.setScene(sceneCompare);
        stage.show();
    }
}
