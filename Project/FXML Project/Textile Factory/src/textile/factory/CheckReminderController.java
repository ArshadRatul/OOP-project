/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textile.factory;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class CheckReminderController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void setreminder(MouseEvent event) throws IOException {
        Parent newparent=FXMLLoader.load(getClass().getResource("Set reminder.fxml"));
        Scene newsecne;
        newsecne = new Scene(newparent);
        Stage stage2=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage2.setScene(newsecne);
        stage2.show();
    }

    @FXML
    private void editreminder(MouseEvent event) throws IOException {
        Parent newparent=FXMLLoader.load(getClass().getResource("EditReminder.fxml"));
        Scene newsecne;
        newsecne = new Scene(newparent);
        Stage stage2=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage2.setScene(newsecne);
        stage2.show();  
    }

    @FXML
    private void deletereminder(MouseEvent event) throws IOException {
        Parent newparent=FXMLLoader.load(getClass().getResource("DeleteReminder.fxml"));
        Scene newsecne;
        newsecne = new Scene(newparent);
        Stage stage2=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage2.setScene(newsecne);
        stage2.show();
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

    @FXML
    private void HomeButton(MouseEvent event) throws IOException {
        Parent NewParent = FXMLLoader.load(getClass().getResource("Managing Director.fxml"));
              Scene scene2= new Scene(NewParent);
              Stage newstage;
              newstage = (Stage)((Node)event.getSource()).getScene().getWindow();
              newstage.setTitle("Managing Director");
              newstage.setScene(scene2);
              newstage.show();
    }

    @FXML
    private void LogoutButton(MouseEvent event) throws IOException {
        Alert a= new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Alert");
        a.setHeaderText("Are you sure?");
        a.setContentText("Press \"OK\" to logout");
        Optional<ButtonType> result=a.showAndWait();
        if(result.get()==ButtonType.OK)
        {
            Parent logoutparent= FXMLLoader.load(getClass().getResource("LoginUI.fxml"));
            Scene logoutScene= new Scene(logoutparent);
            Stage newstage;
            newstage = (Stage)((Node)event.getSource()).getScene().getWindow();
            newstage.setTitle("ARSHAD TEXTILE");
            newstage.setScene(logoutScene);
            newstage.show();
        }
    }
    
    
}
