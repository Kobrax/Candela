package com.View;

import com.Controller.DisplayLotController;
import com.Controller.LoginController;
import com.Controller.LotTableController;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Created by MazurJestBoski on 2016-05-13.
 */
public class MenuView {

    public void start(String loggedUser) {
        LotTableController lotTableController = new LotTableController();
        DisplayLotController displayLotController = new DisplayLotController();
        Stage stage= new Stage();
        Button saveButton = new Button("Save");

        ///CREATING LABELS FOR FULL LOT VIEW
        Label emptyLabel = new Label("");
        Label emptyLabel2 = new Label("Edit");
        emptyLabel2.setFont(new Font("Arial", 20));
        Label lotNumber = new Label("Lot Number: ");
        lotNumber.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label realEstateRegister = new Label("Real Estate Register: ");
        realEstateRegister.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label area = new Label("Area: ");
        area.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label geodeticRegion = new Label("Geodetic Region: ");
        geodeticRegion.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label identificationNumber = new Label("Identification Number: ");
        identificationNumber.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label typeLot = new Label("Lot Type: ");
        typeLot.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label address = new Label("Address: ");
        address.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label cadastralUnit = new Label("Cadastral Unit: ");
        cadastralUnit.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label description = new Label("Description: ");
        description.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        //////////////////////////////////////////////////////////////
        ////CREATING TEXTFIELDS FOR FULL LOT VIEW////
        TextField lotNumberT = new TextField();
        TextField realEstateRegisterT = new TextField();
        TextField areaT = new TextField();
        TextField geodeticRegionT = new TextField();
        TextField identificationNumberT = new TextField();
        TextField typeLotT = new TextField();
        TextField addressT = new TextField();
        TextField cadastralUnitT = new TextField();
        TextField descriptionT = new TextField();


        ////////////GRIDPANE ITEM PLACING///////////////
        GridPane lotManageGridPane = new GridPane(); /// gridPane for lotViewing/adding/editing
        lotManageGridPane.setVgap(22);
        lotManageGridPane.setHgap(10);
        lotManageGridPane.addColumn(0, emptyLabel, lotNumber, realEstateRegister, area, geodeticRegion,
                identificationNumber, typeLot, address, cadastralUnit, description);
        lotManageGridPane.addColumn(1, emptyLabel2, lotNumberT, realEstateRegisterT, areaT, geodeticRegionT,
                identificationNumberT, typeLotT, addressT, cadastralUnitT, descriptionT, saveButton);
        ////////////////////////////////////////////////

        ////////displaying lot info in textFields//////////

        lotTableController.tableView.setRowFactory(tableView ->{
            TableRow<ObservableList> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if(event.getClickCount() ==1 && (!row.isEmpty())){
                    ObservableList<String> getData = row.getItem();
                    String lotN = getData.get(1);
                    System.out.println(displayLotController.lotInfo(lotN));
                    //lotNumberT.setText(displayLotController.lotInfo(lotN).get(0).toString());
                }
            });
            return row;
        });










        //////////////////////////////////////TableWindow////////////////////////////////////////////////
        final Label labelLot = new Label("Your lots");
        labelLot.setFont(new Font("Arial", 20));

        Button buttonMain1 = new Button("Add");
        Button buttonMain2 = new Button("Edit");
        Button buttonMain3 = new Button("Delete");
        Button exit = new Button("Exit");

        BorderPane borderPane1 = new BorderPane();
        Scene scene1 = new Scene(borderPane1, 700, 700);
        lotTableController.tableView = new TableView();
        lotTableController.createTable(loggedUser);

        Button compareButton = new Button("Compare");
        VBox tableVbox = new VBox();
        Button searchButton = new Button("Search");
        TextField searchfield = new TextField();
        HBox hBox2 = new HBox(5);
        hBox2.getChildren().addAll(searchfield, searchButton);

        ScrollPane scrollPane = new ScrollPane(lotTableController.tableView);
        HBox hBox1 = new HBox(5);
        hBox1.getChildren().addAll(buttonMain1, buttonMain2, buttonMain3, compareButton);
        tableVbox.setSpacing(5);
        tableVbox.setPadding(new Insets(10, 0, 0, 10));
        tableVbox.getChildren().addAll(labelLot, scrollPane, hBox1, hBox2);
        HBox hBox = new HBox();
        hBox.getChildren().addAll(tableVbox, lotManageGridPane);
        borderPane1.setLeft(hBox);
        hBox.setSpacing(10);
        borderPane1.setBottom(exit);
        borderPane1.setPadding(new Insets(10, 10, 10, 10));
        borderPane1.setId("backgroundImage");

        scene1.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());




        stage.setScene(scene1);
        stage.show();

    }
}
