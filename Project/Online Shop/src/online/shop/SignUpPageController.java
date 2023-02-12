/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.shop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class SignUpPageController implements Initializable {

    @FXML
    private TextField Username;
    @FXML
    private ComboBox Category;
    @FXML
    private Label ErrorMessage;
    @FXML
    private PasswordField Password;
    @FXML
    private TextField Name;
    @FXML
    private TextField Mobile;
    @FXML
    private DatePicker DOB;
    @FXML
    private TextField NID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Category.getItems().add("Customer");
        Category.setValue("Customer");
    }    

    @FXML
    private void signupButton(MouseEvent event) {
        if(!Username.getText().equals("") &&
           !Name.getText().equals("") && 
           !Password.getText().equals("") && 
           !Mobile.getText().equals("") &&
           !DOB.getValue().equals(null) &&
           !NID.getText().equals("") 
           )
        {
            //add to file 
        }
        else
        {
            Alert a= new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning");
            a.setHeaderText("Please fill all the fields");
            a.setContentText("Click \"OK\" to continue");
            a.showAndWait();
        }
    }

    @FXML
    private void backButton(MouseEvent event) throws IOException {
        Parent next=FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene nextscene= new Scene(next);
        Stage nextstage=(Stage)((Node)event.getSource()).getScene().getWindow();
        nextstage.setScene(nextscene);
        nextstage.show();
    }
    
}
