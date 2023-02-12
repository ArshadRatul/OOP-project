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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class SupplierUpdateController implements Initializable {

    @FXML
    private TextField Name;
    @FXML
    private TextField Quantity;
    @FXML
    private TextField Price;
    @FXML
    private ComboBox Sector;
    @FXML
    private TextArea Description;
    @FXML
    private TextField NewName;
    @FXML
    private Label OldQuantity;
    @FXML
    private Label OldPrice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Sector.getItems().addAll("Machinery", "Silk", "Wool", "Cotton", "Royon", "Polyester","Nylon");
        Sector.setValue("Machinery");
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
                        Description.setText(tokens[4]);
                        OldQuantity.setText(tokens[2]);
                        OldPrice.setText(tokens[3]);
                        return true;
                    }                    
                }
            }
        }catch(IOException e)
        {
            
        }
        return false;
    }
     void updateproduct()
    {
        File f1,f2;
        FileWriter fw=null;
        Scanner s;
        try{
            f1=new File("SupplierProducts.txt");
            f2=new File("Helping.txt");
            if(f1.exists())
            {
                s=new Scanner(f1);
                fw=new FileWriter(f2);
                String line; String[] tokens;
                while(s.hasNextLine())
                {
                    line=s.nextLine();
                    tokens= line.split(",");
                    if(tokens[0].equals(Name.getText()) && tokens[1].equals(Sector.getValue()))
                    {
                        int n=0;
                        tokens[0]=NewName.getText();
                        tokens[2]=Quantity.getText();
                        tokens[0]=Price.getText();
                        tokens[0]=Description.getText();

                        for(String x:tokens)
                        {
                            fw.append(x);
                            ++n;
                            if(n<tokens.length){fw.append(",");}
                        }
                        fw.append("\n");
                    }
                    else
                    {
                        fw.append(line+"\n");
                    }
                }
            }
        }catch(IOException e){}
        finally{
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(RemoveUserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try
        {
            f1=new File("Helping.txt");
            f2=new File("SupplierProducts.txt");
            if(f1.exists())
            {
                s=new Scanner(f1);
                fw=new FileWriter(f2);
                String line; String[] tokens;
                while(s.hasNextLine())
                {
                    line= s.nextLine();
                    tokens=line.split(",");
                    fw.append(line+"\n");
                }
                
            }
        }catch(IOException e){}
        finally{
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(RemoveUserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void Updatebutton(MouseEvent event) {
        if(!Name.getText().equals("") && !Description.getText().equals("") && !Quantity.getText().equals("") && !Price.getText().equals("") )
        {
            updateproduct();
            Alert a=new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("You product is successfully updated");
            a.showAndWait();
        }
        else
        {
            Alert a= new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText("Please fill all the fields to update");
                a.setContentText("Press OK to continue");
                a.showAndWait();
        }
    }

    @FXML
    private void Showvalues(MouseEvent event) {
        if(Check()==false)
        {
            Alert A=new Alert(Alert.AlertType.ERROR);
            A.setHeaderText("Name or Sector do not match");
            A.showAndWait();
        } 
    }

}
