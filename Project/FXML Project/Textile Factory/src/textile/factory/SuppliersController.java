/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textile.factory;

import ClassesUsed.SupplierProductList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
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
public class SuppliersController implements Initializable {

    @FXML
    private BorderPane MidPart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File f=new File("Order.txt");
        File f2=new File("My orders.txt");
        int L1=0,L2=0;
        FileWriter fw=null;
        Scanner s=null,s2=null;
        try {
            s = new Scanner(f);
            s2= new Scanner(f2);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String line; 
        String line2 = null;
        try{
            while(s.hasNextLine())
            {
               ++L1;
            }
        }catch(Exception w)
        {
            
        }
        try{
            while(s2.hasNextLine())
            {
                line2=s2.nextLine();
                ++L2;
            }
        }catch(Exception p)
        {
            
        }
        if(L1!=L2)
        {
            Alert a= new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("Please Check a new order is placed");
            a.showAndWait();
            try {
                fw=new FileWriter(f2);
                fw.append(line2+"\n");
                
            } catch (IOException ex) {

                Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(SuppliersController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
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
            MidPart.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(FactoryManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    @FXML
    private void checkOrders(MouseEvent event) {
    }

    @FXML
    private void checkBills(MouseEvent event) {
    }

    @FXML
    private void checkAppointments(MouseEvent event) {
    }

    @FXML
    private void checkFeedback(MouseEvent event) {
    }

    @FXML
    private void addUpdateButton(MouseEvent event) {
        loadUI("AddUpdateProducts.fxml");
    }

    @FXML
    private void HomeButton(MouseEvent event) throws IOException {
        Parent NewParent = FXMLLoader.load(getClass().getResource("Suppliers.fxml"));
              Scene scene2= new Scene(NewParent);
              Stage newstage;
              newstage = (Stage)((Node)event.getSource()).getScene().getWindow();
              newstage.setTitle("Suppliers");
              newstage.setScene(scene2);
              newstage.show();
    }
    
}
