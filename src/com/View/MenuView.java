package com.View;

import com.Controller.LoginController;
import com.Controller.LotTableController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by MazurJestBoski on 2016-05-13.
 */
public class MenuView {
    public void start() {
        LotTableController lotTableController = new LotTableController();
        LoginController loginController = new LoginController();
        String loggedUser = loginController.loggedUser;

        Stage stage= new Stage();
        BorderPane borderPane = new BorderPane();

        lotTableController.tableView = new TableView();
        lotTableController.createTable(loggedUser);
        ScrollPane scrollPane = new ScrollPane(lotTableController.tableView);

        Scene scene = new Scene(borderPane, 700, 700);
        Button exit = new Button("Exit");

        borderPane.setLeft(scrollPane);
        borderPane.setBottom(exit);
        stage.setScene(scene);
        stage.show();

    }
}
