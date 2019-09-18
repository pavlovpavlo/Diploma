package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;


public class ControllerRG
{
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private WebView web;


    @FXML
    void initialize() throws InterruptedException {
        web.setPrefHeight(758);
        web.setPrefWidth(1400);
        WebEngine engine = web.getEngine();
        engine.load(this.getClass().getResource("index.html").toExternalForm());
    }
}
