package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ControllerSteps {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> Plist;

    @FXML
    void initialize() throws IOException {
        ObservableList<String> list= FXCollections.observableArrayList();
        for(int i=0;i<RegularInAutomation.automationGramar.getStepLength();i++)
            list.add(RegularInAutomation.automationGramar.getSteps(i));
        Plist.setItems(list);

    }
    }