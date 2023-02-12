/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtry.fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Asus
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField value_of_X;
    @FXML
    private Button add_button;
    @FXML
    private TextField value_of_Y;
    @FXML
    private Label result;
    @FXML
    private Button sub;
    @FXML
    private Button Multi;
    @FXML
    private Button div;
    @FXML
    private PasswordField passx;
    @FXML
    private PasswordField passy;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void add_button(MouseEvent event) {
        String valx=value_of_X.getText();
        String valy=value_of_Y.getText();
        int x= Integer.parseInt(valx);
        int y=Integer.parseInt(valy);
        int z=x+y;
        result.setText("Result: "+Integer.toString(z));
        
    }

    @FXML
    private void sub_button(MouseEvent event) {
        result.setText("Result: "+ Integer.toString(
                Integer.parseInt(value_of_X.getText())- Integer.parseInt(value_of_Y.getText()))
                      );
    }

    @FXML
    private void Multi_button(MouseEvent event) {
        result.setText("Result: "+ Integer.toString(
                Integer.parseInt(value_of_X.getText())*Integer.parseInt(value_of_Y.getText()))
                      );
    }

    @FXML
    private void div(MouseEvent event) {
        result.setText("Result: "+ Integer.toString(
                Integer.parseInt(value_of_X.getText())/ Integer.parseInt(value_of_Y.getText()))
                      );
    }
    
}
