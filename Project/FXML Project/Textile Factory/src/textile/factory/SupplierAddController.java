/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textile.factory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class SupplierAddController implements Initializable {

    @FXML
    private AnchorPane ancor;
    @FXML
    private TextArea Description;
    @FXML
    private TextField Name;
    @FXML
    private TextField Quantity;
    @FXML
    private TextField Price;
    @FXML
    private ComboBox Sector;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Sector.getItems().addAll("Machinery", "Silk", "Wool", "Cotton", "Royon", "Polyester","Nylon");
    }    

    boolean Check()
    {
        File f;
        try{
            f= new File("SupplierProducts.txt");
            if(f.exists())
            {
                Scanner s=new Scanner(f);
                String line;String[] tokens;
                while(s.hasNextLine())
                {
                    line=s.nextLine();
                    tokens= line.split(",");
                    if(tokens[0].equals(Name.getText()) && tokens[1].equals(Sector.getValue()) )
                    {
                        return true;
                    }                    
                }
            }
        }catch(IOException e)
        {
            
        }
        return false;
    }
    @FXML
    private void Addbutton(MouseEvent event) {
        File f; FileWriter fw=null;
        try{
            f=new File("SupplierProducts.txt");
            
            if(!Name.getText().equals("") && !Description.getText().equals("") && !Quantity.getText().equals("") && !Price.getText().equals("") )
            {
                if(f.exists()){
                    if(Check()==true)
                    {
                        Alert b=new Alert(Alert.AlertType.WARNING);
                        b.setTitle("Warning");
                        b.setHeaderText("The product already exist");
                        b.setContentText("Try with another product name");
                        b.showAndWait();

                    }
                    else
                    {
                        fw=new FileWriter(f,true);
                        String user= Name.getText()+","
                                +Sector.getValue()+","
                                +Quantity.getText()+","
                                +Price.getText()+","
                                +Description.getText()+"\n";

                        fw.append(user);
                        Name.clear();
                        Quantity.clear();
                        Price.clear();
                        Description.clear();
                        Sector.getSelectionModel().clearSelection();
                        Alert c=new Alert(Alert.AlertType.INFORMATION);
                        c.setTitle("Information");
                        c.setHeaderText("The product is added");
                        c.setContentText("Press OK to continue");
                        c.showAndWait();
                    }
                }
                else{
                    fw=new FileWriter(f,true);
                        String user= "Softwool,"+"Wool,"+"100,"+"50,"+"This product costs 50taka per kg and the quantity is in kg\n";
                        String user2="Hardwool,Wool,150,100,This product costs 50taka per kg and the quantity is in kg\n";
                        String user3="Hardsilk,Silk,150,100,This product costs 50taka per kg and the quantity is in kg\n";
                        String user4="SoftSilk,Silk,150,100,This product costs 50taka per kg and the quantity is in kg\n";
                        String user5="Plastic,Polyester,150,100,This product costs 50taka per kg and the quantity is in kg\n";
                        String user6="Casing,Polyester,150,100,This product costs 50taka per kg and the quantity is in kg\n";
                        fw.write(user);
                        fw.append(user2);
                        fw.append(user3);
                        fw.append(user4);
                        fw.append(user5);
                        fw.append(user6);
                        Name.clear();
                        Quantity.clear();
                        Price.clear();
                        Description.clear();
                        Sector.getSelectionModel().clearSelection();
                        Alert c=new Alert(Alert.AlertType.INFORMATION);
                        c.setTitle("Information");
                        c.setHeaderText("The product is added");
                        c.setContentText("Press OK to continue");
                        c.showAndWait();
                }
            }
            else
            {
                Alert a= new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText("Please fill all the fields to sign-up");
                a.setContentText("Press OK to continue");
                a.showAndWait();
                
            }
        }catch(IOException e){
            System.out.println("ERROR");
        }
        finally{
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(LoginUIController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
