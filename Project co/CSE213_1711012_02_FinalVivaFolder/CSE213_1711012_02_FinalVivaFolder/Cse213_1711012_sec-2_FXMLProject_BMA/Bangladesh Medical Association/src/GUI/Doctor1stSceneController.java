
package GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
//import java.time.Month;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Doctor1stSceneController implements Initializable {

    @FXML
    private Button backBtn;
    @FXML
    private Button registerBtn;
    @FXML
    private Button checkBMAHisotyrBtn;
    @FXML
    private Button checkBMAConstitutionBtn;
    @FXML
    private Button sendMessageBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    

    @FXML
    private void backBtnOnClick(ActionEvent event)  throws IOException
    {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("scene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2);
        window.show();

    }

    @FXML
    private void registerBtnOnClick(ActionEvent event) throws IOException
    {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("doctorRegister2.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2);
        window.show();
        
    }

    @FXML
    private void checkBMAHistoryBtnOnClick(ActionEvent event)  throws IOException
    {  
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("bmaHistory2ndscene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2);
        window.show();
        
    }

    @FXML
    private void checkBMAConstitutionBtnOnClick(ActionEvent event)  throws IOException
    {
          Parent scene2Parent = FXMLLoader.load(getClass().getResource("bmaConstitution2ndScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2);
        window.show();
    }

    @FXML
    private void sendMessageBtnOnClick(ActionEvent event)  throws IOException
    {
          Parent scene2Parent = FXMLLoader.load(getClass().getResource("sendthemassaganothemember2ndscene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2);
        window.show();
    }
    
}
