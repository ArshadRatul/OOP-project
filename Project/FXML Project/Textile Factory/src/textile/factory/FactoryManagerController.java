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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FactoryManagerController implements Initializable {

    @FXML
    private BorderPane midpart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void loadUI(String a)
    {
        Parent root;
        try {
            root=FXMLLoader.load(getClass().getResource(a));
            midpart.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(FactoryManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @FXML
    private void HomeButton(MouseEvent event) throws IOException {
        Parent NewParent = FXMLLoader.load(getClass().getResource("Factory Manager.fxml"));
              Scene scene2= new Scene(NewParent);
              Stage newstage;
              newstage = (Stage)((Node)event.getSource()).getScene().getWindow();
              newstage.setTitle("Factory Manager");
              newstage.setScene(scene2);
              newstage.show();
    }

    @FXML
    private void signUpButton(MouseEvent event) {
        loadUI("SignUpUser.fxml");
    }

    @FXML
    private void removeUserButton(MouseEvent event) {
        loadUI("RemoveUser.fxml");
    }

    @FXML
    private void addNewProjectButton(MouseEvent event) {
        loadUI("Add new project.fxml");
    }

    @FXML
    private void checkProductionReportButton(MouseEvent event) {
        loadUI("Check Production report fm.fxml");
    }

    @FXML
    private void hireFireButton(MouseEvent event) {
    }

    @FXML
    private void orderRawMaterialButton(MouseEvent event) {
        loadUI("OrderRawMaterials.fxml");
    }
    
}
