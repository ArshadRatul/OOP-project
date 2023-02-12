/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textile.factory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class DeleteReminderController implements Initializable {

    @FXML
    private DatePicker Date;
    @FXML
    private TextField Title;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void deleteButton(MouseEvent event) {
    }

    @FXML
    private void BackButton(MouseEvent event) throws IOException {
        Parent newparent=FXMLLoader.load(getClass().getResource("CheckReminder.fxml"));
        Scene newsecne;
        newsecne = new Scene(newparent);
        Stage stage2=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage2.setScene(newsecne);
        stage2.show();
    }
    
}
