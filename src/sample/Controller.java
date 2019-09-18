package sample;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Controller
{
    ObservableList<String> list= FXCollections.observableArrayList();
   public static RegGramar regGramar ;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField input_p_txt;

    @FXML
    private Button Convertbtn;

    @FXML
    private TextField VTtxt;

    @FXML
    private Button AddBtn;

    @FXML
    private Button Prbtn;

    @FXML
    private ListView<String> Plist;

    @FXML
    private TextField VNtxt;

    @FXML
    private TextField Stxt;

    @FXML
    void initialize()
    {
        regGramar = new RegGramar();

        Prbtn.setOnMouseClicked(event ->
        {
            ObservableList<String> lists= FXCollections.observableArrayList();
            VNtxt.setText("C,S,F,M,T,D,R");
            VTtxt.setText("0,1,2,3,4,5,6,7,8,9,g,s");
            Stxt.setText("C");
            lists.add("C=D2|g");
            lists.add("S=Cs|F0|F1|F2|F3|F4|F5|S0|S1|S2|S3|S4|S5|S6|S7|S8|M0|M1|M2|M3|M4|M5|M6|M7|M8|D0|D1|T0|T1|T2|T3|T4|T5|T6|T7|T8");
            lists.add("F=S9");
            lists.add("R=M9");
            lists.add("T=R6");
            lists.add("M=F6|R0|R1|R2|R3|R4|R5");
            lists.add("D=T9");
            Plist.setItems(lists);
            list=lists;

        });

        input_p_txt.setOnKeyReleased
                (
                        event ->
                        {
                            if((VNtxt.getText().indexOf(Character.toString(input_p_txt.getText().charAt(input_p_txt.getText().length()-1)))>=0)
                                    || VTtxt.getText().indexOf(Character.toString(input_p_txt.getText().charAt(input_p_txt.getText().length()-1)))>=0
                                    || (Character.toString(input_p_txt.getText().charAt(input_p_txt.getText().length()-1)).equals("|")&&!Character.toString(input_p_txt.getText().charAt(input_p_txt.getText().length()-2)).equals("|")&&
                                    !Character.toString(input_p_txt.getText().charAt(input_p_txt.getText().length()-2)).equals("="))
                                    ||(( Character.toString(input_p_txt.getText().charAt(input_p_txt.getText().length()-1)).equals("=") &&input_p_txt.getText().length()==2)))
                            {
                                if(input_p_txt.getText().length()==1
                                        &&!(VNtxt.getText().indexOf(Character.toString(input_p_txt.getText().charAt(input_p_txt.getText().length()-1)))>=0))
                                input_p_txt.clear();
                                    if(input_p_txt.getText().length()>3)
                                    {
                                        if ((VNtxt.getText().indexOf(Character.toString(input_p_txt.getText().charAt(input_p_txt.getText().length() - 1))) >= 0)
                                                && !Character.toString(input_p_txt.getText().charAt(input_p_txt.getText().length() - 2)).equals("|")) {
                                            input_p_txt.setText(input_p_txt.getText().substring(0, input_p_txt.getText().length() - 1));
                                            input_p_txt.selectPositionCaret(input_p_txt.getText().length());
                                        }
                                    }
                            }
                            else
                            {
                                input_p_txt.setText(input_p_txt.getText().substring(0,input_p_txt.getText().length()-1));
                                input_p_txt.selectPositionCaret(input_p_txt.getText().length()+1);
                            }
                        }
                );
        Stxt.setOnKeyReleased
                (
                        event->
                        {
                          if((VNtxt.getText().indexOf(Character.toString(Stxt.getText().charAt(Stxt.getText().length()-1)))<0) || Stxt.getText().length()>1) Stxt.clear();
                            else
                          {
                            input_p_txt.setText(Stxt.getText()+"=");
                          }
                        }
                );
        VTtxt.setOnKeyReleased
                (
                        event ->
                        {
                            if(VNtxt.getText().indexOf(Character.toString(VTtxt.getText().charAt(VTtxt.getText().length()-1)))<0
                                    ||(Character.toString(VTtxt.getText().charAt(VTtxt.getText().length()-1))).equals(",")
                                    ||(Character.toString(VTtxt.getText().charAt(VTtxt.getText().length()-1))).equals('"')) System.out.println("");/*regGramar.setVT(Character.toString(VTtxt.getText().charAt(VTtxt.getText().length()-1)));*/
                                else
                                    {
                                        VTtxt.setText(VTtxt.getText().substring(0,VTtxt.getText().length()-1));
                                        VTtxt.selectPositionCaret(VTtxt.getText().length()+1);
                                    }
                        }
                );
        VNtxt.setOnKeyReleased
                (
                        event ->
                        {
                            if(!(VTtxt.getText().indexOf(Character.toString(VNtxt.getText().charAt(VNtxt.getText().length()-1)))>=0)
                                    ||(Character.toString(VNtxt.getText().charAt(VNtxt.getText().length()-1))).equals(",")) System.out.println("");/*regGramar.setVT(Character.toString(VTtxt.getText().charAt(VTtxt.getText().length()-1)));*/
                            else
                            {
                                VNtxt.setText(VNtxt.getText().substring(0,VNtxt.getText().length()-1));
                                VNtxt.selectPositionCaret(VNtxt.getText().length()+1);
                            }
                        }
                );
        AddBtn.setOnMouseClicked
                (
                event ->
                {
                    if(input_p_txt.getText().length()>2) {
                        list.add(input_p_txt.getText().trim() );
                        Plist.setItems(list);
                        input_p_txt.clear();
                    }
                    else
                    {
                        Alert alert= new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);

                        alert.setContentText("Ви не повністю написали правило!");
                        alert.showAndWait();
                    }
                }
                );
        Convertbtn.setOnMouseClicked
                (
                        event ->
                        {
                            if (!(list.size() < 1))
                            {
                                if (Stxt.getText().length() < 1 || VNtxt.getText().length() < 1 || VTtxt.getText().length() < 1)
                                {
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setTitle("Error");
                                    alert.setHeaderText(null);

                                    alert.setContentText("Будь ласка заповніть всі поля!");
                                    alert.showAndWait();
                                } else
                                {
                                    regGramar.setS(Stxt.getText());
                                    VT_Analysator();
                                    VN_Analysator();
                                    try {
                                        P_Analysator(list);
                                    } catch (Exception e) {
                                        Alert alert = new Alert(Alert.AlertType.ERROR);
                                        alert.setTitle("Error");
                                        alert.setHeaderText(null);

                                        alert.setContentText(e.getMessage());
                                        alert.showAndWait();
                                        list.clear();
                                        Plist.setItems(list);
                                        VNtxt.clear();
                                        VTtxt.clear();
                                        Stxt.clear();
                                        return;
                                    }
                                    regGramar.setS(Stxt.getText());


                                    try {
                                        //System.out.println("tytss");
                                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sampleSM.fxml"));
                                        Parent root = (Parent) fxmlLoader.load();
                                        Stage stage = new Stage();
                                        stage.setScene(new Scene(root));
                                        stage.setTitle("Павлов П.О. Программа перетворення регулярної граматики годинника в скінченний автомат.");
                                        stage.setOnCloseRequest(event1 ->
                                            System.exit(0)
                                        );
                                        stage.show();

                                        Convertbtn.getScene().getWindow().hide();
                                        ControllerSM controller = fxmlLoader.getController();

                                        stage.setOnCloseRequest(controller.getCloseEventHandler());

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            else
                                    {
                                        Alert alert = new Alert(Alert.AlertType.ERROR);
                                        alert.setTitle("Error");
                                        alert.setHeaderText(null);

                                        alert.setContentText("Додайте хоча б одне правило");
                                        alert.showAndWait();
                                    }
                                }


                );
    }
    public void VT_Analysator()
    {
        for (int i=0;i<VTtxt.getText().length();i++)
        {
            if(!Character.toString(VTtxt.getText().charAt(i)).equals(","))
                regGramar.setVT(Character.toString(VTtxt.getText().charAt(i)));
        }
    }
    public void VN_Analysator()
    {
        for (int i=0;i<VNtxt.getText().length();i++)
        {
            if(!Character.toString(VNtxt.getText().charAt(i)).equals(","))
                regGramar.setVN(Character.toString(VNtxt.getText().charAt(i)));
        }
    }
    public void P_Analysator(ObservableList<String> list) throws Exception
    {
        for(String symbol:list) {
            String Pravilo;
                Pravilo = symbol;
                try {
                    if (regGramar.IsNotTerminal(Pravilo.substring(0, Pravilo.indexOf("=")))) {
                    } else {
                        throw new Exception("Символ не є нетермінальним або неправильно задана ліва частина правила: " + Pravilo.substring(0, Pravilo.indexOf("=")));
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    throw new Exception("Граматика повинна мати вигляд S=Pa|Aa");
                }
                String P1 = "";
                for (int i = 2; i < Pravilo.length(); i++)
                {
                    if (regGramar.IsNotTerminal(Character.toString(Pravilo.charAt(i))))
                    {
                        if (i > 0 && !Character.toString(Pravilo.charAt(i - 1)).equals("|") && !Character.toString(Pravilo.charAt(i - 1)).equals("="))
                            throw new Exception("Це не ліволінійна регулярна граматика, правило виду: " + Pravilo.substring(0) + " не є правилом ліволінійної граматики, продивіться довідку!");
                        else P1 += Character.toString(Pravilo.charAt(i));
                    }
                    else
                        if (regGramar.IsTerminal(Character.toString(Pravilo.charAt(i))))
                        P1 += Character.toString(Pravilo.charAt(i));
                             else
                                 if (!Character.toString(Pravilo.charAt(i)).equals("|"))
                        throw new Exception("Невідомий символ " + Pravilo.charAt(i));
                                    else
                                 {
                                    regGramar.setP(Pravilo.charAt(0) + "=" + P1);
                                    P1 = "";
                                 }
                }
                regGramar.setP(Pravilo.charAt(0) + "=" + P1);
        }
    }
}
