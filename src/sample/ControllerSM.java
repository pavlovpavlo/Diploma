package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.RegularInAutomation.automationGramar;

public class ControllerSM {
    ObservableList<String> lists= FXCollections.observableArrayList();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField VTtxt;

    @FXML
    private ListView<String> Plist;

    @FXML
    private TextField VNtxt;

    @FXML
    private TextField Stxt;

    @FXML
    private TextField Vtxt;

    @FXML
    private Button AGbtn;

    @FXML
    private Button Gbtn;

    @FXML
    private ListView<String> blist;

    @FXML
    private TextField Ftxt1;

    @FXML
    private TextField Qtxt;

    @FXML
    private Button Stepbtn;

    @FXML
    private TextField q0txt;
    @FXML

    void initialize()
    {


        ObservableList<String> list= FXCollections.observableArrayList();
        RegularInAutomation regularInAutomation = new RegularInAutomation();
        regularInAutomation.Step_One();
        regularInAutomation.Step_Two();
        regularInAutomation.Step_Three();

        GenerateSM generateSM= new GenerateSM();
        generateSM.Step_One();
        generateSM.Step_Two();
        generateSM.Step_Three();
        generateSM.Step_Four();
        generateSM.Step_Five();
        StateMachine st=GenerateSM.stateMachine;
        //----------------------------------------------------------------------
        Stxt.setText(automationGramar.getS());
        VNtxt.setText(automationGramar.getVN(0));
        for (int i=1;i<automationGramar.getVNLength();i++)
            VNtxt.setText(VNtxt.getText()+", "+automationGramar.getVN(i));
        VTtxt.setText(automationGramar.getVT(0));
        for (int i=1;i<automationGramar.getVTLength();i++)
            VTtxt.setText(VTtxt.getText()+", "+automationGramar.getVT(i));
        for (int i=0;i<automationGramar.getPLength();i++)
            lists.add (automationGramar.getP(i));
        Plist.setItems(lists);
        //--------------------------------------------------------------------------------------
            q0txt.setText(st.getQ0());
            Qtxt.setText(st.getQ(0));
        for (int i=1;i<st.getQLength();i++)
            Qtxt.setText(Qtxt.getText()+", "+st.getQ(i));
        Vtxt.setText(st.getV(0));
        for (int i=1;i<st.getVLength();i++)
            Vtxt.setText(Vtxt.getText()+", "+st.getV(i));
        for (int i=0;i<st.getTFLength();i++)
          list.add (st.getTransactionFunction(i));
        blist.setItems(list);
        Ftxt1.setText(st.getF(0));
        for (int i=1;i<st.getFLength();i++)
            Ftxt1.setText(Ftxt1.getText()+", "+st.getF(i));



        Gbtn.setOnMouseClicked
                (
                        event -> Main.main(new String[]{})
                );
        Stepbtn.setOnMouseClicked((MouseEvent event) ->
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sampleSteps.fxml"));
            Parent root = null;
            try {
                root =  fxmlLoader.load();
            } catch (IOException e) {
e.printStackTrace();
            }

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Павлов П.О. Программа перетворення регулярної граматики годинника в скінченний автомат.");
            stage.show();
        });
        AGbtn.setOnMouseClicked((MouseEvent event) ->
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sampleRG.fxml"));
            Parent root = null;
            try {
                root =  fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setTitle("Павлов П.О. Программа перетворення регулярної граматики годинника в скінченний автомат.");
            stage.setMaxWidth(600);
            stage.setMaxHeight(620);
            stage.setScene(new Scene(root));
            stage.setTitle("Павлов П.О. Программа перетворення регулярної граматики годинника в скінченний автомат.");
                    stage.show();

        });
    }
    private javafx.event.EventHandler<WindowEvent> closeEventHandler = new javafx.event.EventHandler<WindowEvent>() {
        @Override
        public void handle(WindowEvent event) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
            Parent root = null;
            try {
                root =  fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
    };

    public javafx.event.EventHandler<WindowEvent> getCloseEventHandler(){
        return closeEventHandler;
    }
}
