/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.shop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Asus
 */
public class LoginPageController implements Initializable {
    
    private Label label;
    @FXML
    private TextField Username;
    @FXML
    private TextField Password;
    @FXML
    private ComboBox Category;
    @FXML
    private Label ErrorMessage;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Category.getItems().addAll("Customer","Manager","Supplier","Managing Director","Delivery Man", "Customer Care");
    }    


    @FXML
    private void signupButton(MouseEvent event) throws IOException {
        Parent next=FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
        Scene nextscene= new Scene(next);
        Stage nextstage=(Stage)((Node)event.getSource()).getScene().getWindow();
        nextstage.setScene(nextscene);
        nextstage.show();
    }

    @FXML
    private void loginButton(MouseEvent event) {
    }

    @FXML
    private void forgetpasswordButton(MouseEvent event) {
    }


    
}
