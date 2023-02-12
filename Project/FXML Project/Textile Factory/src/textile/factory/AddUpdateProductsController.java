/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textile.factory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */

public class AddUpdateProductsController implements Initializable {

    @FXML
    private BorderPane midpart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void UpdateButton(MouseEvent event) {
         loadUI("SupplierUpdate.fxml");
    }

    @FXML
    private void AddButton(MouseEvent event) {
        loadUI("SupplierAdd.fxml");
    }

    @FXML
    private void DeleteButton(MouseEvent event) {
        loadUI("SupplierUpdate2.fxml");
    }
    
}
