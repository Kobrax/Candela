package com.View;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Created by Dom on 2016-05-25.
 */
public class BrowserView {
    public void start() {
        Stage browserStage = new Stage();
        WebView view = new WebView();
        Scene scene = new Scene(view, 900, 900);
        WebEngine webEngine = view.getEngine();


        String url = "https://kolobrzeski.webewid.pl/is2/iEwid/";

        view.isResizable();
        webEngine.load(url);


        browserStage.setScene(scene);
        browserStage.show();


    }
}
