
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class SavetheAnotherHospitalBMAlist1stSceneController implements Initializable {

    @FXML
    private TextArea outputTextArea;
    @FXML
    private Button saveBtn;
    @FXML
    private Button CancelBtn;
    @FXML
    private Button backBtn;

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void backBtnOnClick(ActionEvent event)   throws IOException 
    {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("hospital2ndScence.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2);
        window.show();
    }
    
}
