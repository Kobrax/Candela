package com.Controller;

import com.Model.LoginModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Dom on 2016-05-19.
 */
public class LotTableController {

    public static ObservableList<ObservableList> data;
    public TableView tableView;
    private static Connection conn;

    public void createTable(String loggedUs, String wildcard) {
        data = FXCollections.observableArrayList();
        String enteredByUser = "%" + wildcard + "%";
        try {

            String DB_URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7119030";
            String USER = "sql7119030";
            String PASS = "ira72lBrrp";
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "SELECT lotID, lotNumber, realEstateRegister, area FROM lot WHERE username = ? AND lotNumber like ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, loggedUs);
            preparedStatement.setString(2, enteredByUser);

            ResultSet result = preparedStatement.executeQuery();

            tableMethod(result);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Database problem123");

        }
    }

    public void tableMethod(ResultSet result){
        try{
            // create coulmn
            for (int i = 0; i < result.getMetaData().getColumnCount(); i++) {
// dynamic table coulmns
                final int j = i;
                TableColumn colLot = new TableColumn(result.getMetaData().getColumnName(i + 1));

                colLot.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });
//Add comlumn to lot
                tableView.getColumns().addAll(colLot);
            }


// fill data of Tables rows

            while (result.next()) {
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();

                for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(result.getString(i));
                }

                data.add(row);
            }


            // Add  data TableView
            tableView.setItems(data);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Database problemxyz");

        }}

    public void resetTable()
    {
        if(data!=null){
        data.removeAll(data);
        tableView.getColumns().clear();}
        else
            System.out.println("tableview empty, cannot clear");
    }
}
