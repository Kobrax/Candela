package com.View;

import com.Controller.DisplayLotController;
import com.Controller.LoginController;
import com.Controller.LotTableController;
import com.Controller.ViewController;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Created by MazurJestBoski on 2016-05-13.
 */
public class MenuView {

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


    public void start(String loggedUser, Boolean admin) {
        LotTableController lotTableController = new LotTableController();
        DisplayLotController displayLotController = new DisplayLotController();
        ViewController viewController = new ViewController();
        LoginController loginController = new LoginController();

        Stage stage= new Stage();
        HBox hBox = new HBox(5);
        VBox mapVBox = new VBox(10);
        VBox logOutVbox = new VBox();

        Button saveButton = new Button("Save");
        Button clearButton = new Button("Clear");
        Button add = new Button("Add");
        Button edit = new Button("Edit");
        Button delete = new Button("Delete");
        Button logOutButton = new Button("Log out");
        Button editUser = new Button("Edit account");

        final String[] loginUser = {loggedUser};


        ///CREATING LABELS FOR FULL LOT VIEW
        Label emptyLabel = new Label("");
        Label emptyLabel2 = new Label("Candela");
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

        Image image = new Image(getClass().getResourceAsStream("pics/Map_of_Poland.png"));
        Hyperlink hyperlink = new Hyperlink();
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        hyperlink.setGraphic(imageView);

        hBox.getChildren().addAll(saveButton, clearButton);
        hBox.setAlignment(Pos.BASELINE_RIGHT); ;
        mapVBox.getChildren().addAll(hBox, hyperlink);
        mapVBox.setSpacing(30);


        ////////////GRIDPANE ITEM PLACING///////////////
        GridPane lotManageGridPane = new GridPane(); /// gridPane for lotViewing/adding/editing
        lotManageGridPane.setVgap(18);
        lotManageGridPane.setHgap(10);
        lotManageGridPane.addColumn(0, emptyLabel, lotNumber, realEstateRegister, area, geodeticRegion,
                identificationNumber, typeLot, address, cadastralUnit, description);
        lotManageGridPane.addColumn(1, emptyLabel2, lotNumberT, realEstateRegisterT, areaT, geodeticRegionT,
                identificationNumberT, typeLotT, addressT, cadastralUnitT, descriptionT, mapVBox);


        //////////////////////////////////////TableWindow////////////////////////////////////////////////
        final Label labelLot = new Label("Your lots");
        labelLot.setFont(new Font("Arial", 20));


        BorderPane borderPane1 = new BorderPane();
        Scene scene1 = new Scene(borderPane1, 1000, 730);
        lotTableController.tableView = new TableView();
        if(admin == true){
            lotTableController.createATable("");
        }else{
        lotTableController.createTable(loginUser[0],"");}

        Button compareButton = new Button("Compare");
        VBox tableVbox = new VBox();
        Button searchButton = new Button("Search");
        TextField searchfield = new TextField();
        HBox hBox2 = new HBox(5);
        hBox2.getChildren().addAll(searchfield, searchButton);

        ScrollPane scrollPane = new ScrollPane(lotTableController.tableView);
        HBox hBox1 = new HBox(5);
        hBox1.getChildren().addAll(add, edit, delete, compareButton);

        logOutVbox.getChildren().addAll(hBox2, logOutButton);
        logOutVbox.setSpacing(180);

        tableVbox.setSpacing(5);
        tableVbox.setPadding(new Insets(10, 10, 10, 10));
        tableVbox.getChildren().addAll(labelLot, scrollPane, hBox1, logOutVbox);
        HBox tableHbox = new HBox();
        tableHbox.getChildren().addAll(tableVbox, lotManageGridPane);
        borderPane1.setLeft(tableHbox);
        tableHbox.setSpacing(10);
        borderPane1.setPadding(new Insets(10, 10, 10, 10));
        borderPane1.setId("backgroundImage");

        borderPane1.setTop(editUser);
        borderPane1.setAlignment(editUser, Pos.TOP_RIGHT);


        //////////////////////////////////////////////////////////////////////////
        logOutButton.setStyle("-fx-min-width: 130px;\n" +
                "    -fx-max-width: 130px;\n" +
                "    -fx-background-color:\n" +
                "            #000000,\n" +
                "            #984639;\n" +
                "    -fx-background-insets: 0,1,2,3;\n" +
                "    -fx-background-radius: 3,2,2,2;\n" +
                "    -fx-padding: 12 30 12 30;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-font-size: 12px;");

        clearButton.setStyle("-fx-background-color:\n" +
                "            #000000,\n" +
                "            #984639;\n" +
                "    -fx-text-fill: white;\n");

        compareButton.setStyle("-fx-background-color:\n" +
                "            #000000,\n" +
                "            #984639;\n" +
                "    -fx-text-fill: white;\n");

        saveButton.setStyle("-fx-background-color:\n" +
                "            #000000,\n" +
                "            #984639;\n" +
                "    -fx-text-fill: white;\n");

        searchButton.setStyle("-fx-background-color:\n" +
                "            #000000,\n" +
                "            #984639;\n" +
                "    -fx-text-fill: white;\n");

        add.setStyle("-fx-background-color:\n" +
                "            #000000,\n" +
                "            #984639;\n" +
                "    -fx-text-fill: white;\n");

        edit.setStyle("-fx-background-color:\n" +
                "            #000000,\n" +
                "            #984639;\n" +
                "    -fx-text-fill: white;\n");

        delete.setStyle("-fx-background-color:\n" +
                "            #000000,\n" +
                "            #984639;\n" +
                "    -fx-text-fill: white;\n");

        /////////////////////////////////////////////////////////////////////////


        hyperlink.setOnAction(event2 -> {
            viewController.browser();
        });

        scene1.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());


        ////////displaying lot info in textFields//////////

        lotTableController.tableView.setRowFactory(tableView -> {
            TableRow<ObservableList> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!row.isEmpty())) {
                    ObservableList<String> getData = row.getItem();
                    String lotN = getData.get(1);
                    lotNumberT.setText(displayLotController.lotInfo(lotN).get(0).toString());
                    realEstateRegisterT.setText(displayLotController.lotInfo(lotN).get(1).toString());
                    areaT.setText(displayLotController.lotInfo(lotN).get(2).toString());
                    geodeticRegionT.setText(displayLotController.lotInfo(lotN).get(3).toString());
                    identificationNumberT.setText(displayLotController.lotInfo(lotN).get(4).toString());
                    typeLotT.setText(displayLotController.lotInfo(lotN).get(5).toString());
                    addressT.setText(displayLotController.lotInfo(lotN).get(6).toString());
                    cadastralUnitT.setText(displayLotController.lotInfo(lotN).get(7).toString());
                    descriptionT.setText(displayLotController.lotInfo(lotN).get(8).toString());


                }
            });
            return row;
        });

        ////////////////////////////////////////////////////////////////////

        ////////////////////SETTING SEARCH BUTTON ON ACTION//////////////
        searchButton.setOnAction(event2 -> {
            String wildcard = searchfield.getText();
            System.out.println(wildcard);

            lotTableController.tableView.getColumns().clear();
            if (admin == true) {
                lotTableController.createATable(wildcard);
            }
            else {
                lotTableController.createTable(loginUser[0], wildcard);
            }
            clear();
        });

        ////////////////////////////////////////////////////////////////


        add.setOnAction(event1 ->
        {
            emptyLabel2.setText("New");
        });


        compareButton.setOnAction(event1 ->
        {
            viewController.startCompare(loggedUser, admin);
        });

        saveButton.setOnAction(event ->
        {
            if (emptyLabel2.getText().equals("New")) {
                displayLotController.saveToDB(lotNumberT.getText(), realEstateRegisterT.getText(),
                        Double.parseDouble(areaT.getText()), geodeticRegionT.getText(), identificationNumberT.getText(),
                        typeLotT.getText(), addressT.getText(), cadastralUnitT.getText(), descriptionT.getText(), loginUser[0]);

                lotTableController.data.removeAll(lotTableController.data);
                lotTableController.tableView.getColumns().clear();

                lotTableController.createTable(loginUser[0], "");


                clear();

            } else if (emptyLabel2.getText().equals("Edit")) {
                int rowIndex = lotTableController.tableView.getSelectionModel().getSelectedIndex();
                ObservableList rowList = (ObservableList) lotTableController.tableView.getItems().get(rowIndex);
                int columnIndex = 0;
                int value = Integer.parseInt(rowList.get(columnIndex).toString());

                displayLotController.updateDB(lotNumberT.getText(), realEstateRegisterT.getText(),
                        Double.parseDouble(areaT.getText()), geodeticRegionT.getText(), identificationNumberT.getText(),
                        typeLotT.getText(), addressT.getText(), cadastralUnitT.getText(), descriptionT.getText(), loginUser[0], value);

                clear();

            } else System.out.println("Ups, something go wrong " + loginUser[0]);

        });

        delete.setOnAction(event -> {
            int rowIndex = lotTableController.tableView.getSelectionModel().getSelectedIndex();
            ObservableList rowList = (ObservableList) lotTableController.tableView.getItems().get(rowIndex);
            int columnIndex = 0;
            int value = Integer.parseInt(rowList.get(columnIndex).toString());

            displayLotController.deleteFromDB("lot", value);

            lotTableController.data.removeAll(lotTableController.data);
            lotTableController.tableView.getColumns().clear();
            lotTableController.createTable(loginUser[0], "");
        });

        clearButton.setOnAction(event ->
        {
            clear();
        });


        logOutButton.setOnAction(event ->
        {
            viewController.startLogin();
            loginUser[0] = null;
            stage.close();

        });

        edit.setOnAction(event ->
        {
            emptyLabel2.setText("Edit");
        });

        stage.setResizable(false);
        stage.setScene(scene1);
        stage.show();


        editUser.setOnAction(event ->
        {
            viewController.editUser(loggedUser);
        });

    }

    public void clear()
    {
        lotNumberT.clear();
        realEstateRegisterT.clear();
        areaT.clear();
        geodeticRegionT.clear();
        identificationNumberT.clear();
        typeLotT.clear();
        addressT.clear();
        cadastralUnitT.clear();
        descriptionT.clear();
    }
}
