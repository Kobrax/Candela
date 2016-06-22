package com.View;

import com.Controller.DisplayLotController;
import com.Controller.EditUserController;
import com.Controller.ViewController;
import com.Model.DisplayLot;
import javafx.collections.ObservableList;
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
 * Created by Dom on 2016-05-22.
 */
public class AdminUserView {

    TextField userName = new TextField();
    TextField email = new TextField();
    TextField password = new TextField();
    TextField livingArea = new TextField();
    TextField name = new TextField();
    TextField surname = new TextField();

    public void start()
    {
        EditUserController editUserController = new EditUserController();
        ViewController viewController = new ViewController();
        DisplayLotController editControlelr = new DisplayLotController();


        BorderPane borderPane1 = new BorderPane();
        Scene scene1 = new Scene(borderPane1, 900, 550);
        editUserController.tableView = new TableView();
        editUserController.createAdminTable("");

        Stage stage= new Stage();
        HBox hBox = new HBox(5);
        VBox logOutVbox = new VBox();

        Button saveButton = new Button("Save");
        Button clearButton = new Button("Clear");
        Button delete = new Button("Delete");

        Label emptyLabel = new Label("Edit Account");
        emptyLabel.setFont(new Font("Arial", 20));

        Label emptyLabel2 = new Label("");
        emptyLabel.setFont(new Font("Arial", 20));

        Label userNameLabel = new Label("Username: ");
        userNameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        Label emailLabel = new Label("Email: ");
        emailLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        Label passwordLabel = new Label("Password: ");
        passwordLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        Label areaLabel = new Label("Living Area: ");
        areaLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        Label nameLabel = new Label("Name: ");
        nameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        Label surnameLabel = new Label("Surname: ");
        surnameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));


        hBox.getChildren().addAll(saveButton, clearButton);
        hBox.setAlignment(Pos.BASELINE_RIGHT);

        GridPane lotManageGridPane = new GridPane(); /// gridPane for UserViewing/adding/editing
        lotManageGridPane.setVgap(18);
        lotManageGridPane.setHgap(10);
        lotManageGridPane.addColumn(0, emptyLabel, userNameLabel, emailLabel, passwordLabel, areaLabel,
                nameLabel, surnameLabel);
        lotManageGridPane.addColumn(1, emptyLabel2, userName, email, password, livingArea,
                name, surname, hBox);

        final Label labelLot = new Label("Your lots");
        labelLot.setFont(new Font("Arial", 20));

        VBox tableVbox = new VBox();
        Button searchButton = new Button("Search");
        TextField searchfield = new TextField();
        HBox hBox2 = new HBox(5);
        hBox2.getChildren().addAll(searchfield, searchButton);

        ScrollPane scrollPane = new ScrollPane(editUserController.tableView);


        tableVbox.setSpacing(5);
        tableVbox.setPadding(new Insets(10, 10, 10, 10));
        tableVbox.getChildren().addAll(labelLot, scrollPane, hBox2, delete);
        HBox tableHbox = new HBox();
        tableHbox.getChildren().addAll(tableVbox, lotManageGridPane);
        borderPane1.setLeft(tableHbox);
        tableHbox.setSpacing(10);
        borderPane1.setPadding(new Insets(10, 10, 10, 10));
        borderPane1.setId("backgroundImage");

        scene1.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());

        //////////////////////////////////////////////////////////////////////////

        clearButton.setStyle("-fx-background-color:\n" +
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

        delete.setStyle("-fx-background-color:\n" +
                "            #000000,\n" +
                "            #984639;\n" +
                "    -fx-text-fill: white;\n");

        /////////////////////////////////////////////////////////////////////////


        ////////displaying lot info in textFields//////////

        editUserController.tableView.setRowFactory(tableView -> {
            TableRow<ObservableList> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!row.isEmpty())) {
                    ObservableList<String> getData = row.getItem();
                    String userN = getData.get(1);
                    userName.setText(editUserController.userInfo(userN).get(0).toString());
                    email.setText(editUserController.userInfo(userN).get(1).toString());
                    password.setText(editUserController.userInfo(userN).get(2).toString());
                    livingArea.setText(editUserController.userInfo(userN).get(3).toString());
                    name.setText(editUserController.userInfo(userN).get(4).toString());
                    surname.setText(editUserController.userInfo(userN).get(5).toString());

                }
            });
            return row;
        });

        ////////////////////////////////////////////////////////////////////

        ////////////////////SETTING SEARCH BUTTON ON ACTION//////////////
        searchButton.setOnAction(event2 -> {
            String wildcard = searchfield.getText();
            System.out.println(wildcard);

                editUserController.createAdminTable(wildcard);

            clear();
        });

        ////////////////////////////////////////////////////////////////



        saveButton.setOnAction(event ->
        {
            editUserController.editUser(userName.getText(), password.getText(), email.getText(),
                    livingArea.getText(), name.getText(), surname.getText());
            stage.close();
        });

        delete.setOnAction(event -> {
            int rowIndex = editUserController.tableView.getSelectionModel().getSelectedIndex();
            ObservableList rowList = (ObservableList) editUserController.tableView.getItems().get(rowIndex);
            int columnIndex = 0;
            int value = Integer.parseInt(rowList.get(columnIndex).toString());

            editUserController.deleteUser("users", value);

            editUserController.data.removeAll(editUserController.data);
            editUserController.tableView.getColumns().clear();
            editUserController.createAdminTable("");
        });

        clearButton.setOnAction(event ->
        {
            clear();
        });


        stage.setResizable(false);
        stage.setScene(scene1);
        stage.show();

    }

    public void clear()
    {
        userName.clear();
        email.clear();
        livingArea.clear();
        password.clear();
        name.clear();
        surname.clear();
    }

    }
