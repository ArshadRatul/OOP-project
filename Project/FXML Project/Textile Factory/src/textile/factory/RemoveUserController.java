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
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class RemoveUserController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private ComboBox category;
    @FXML
    private Label ErrorText;

    /**
     * Initializes the controller class.
     */
    boolean Check()
    {
        File f;
        try{
            f= new File("Database.txt");
            if(f.exists())
            {
                Scanner s=new Scanner(f);
                String line;String[] tokens;
                while(s.hasNextLine())
                {
                    line=s.nextLine();
                    tokens= line.split(",");
                    if(tokens[1].equals(username.getText()) && tokens[4].equals(category.getValue()) )
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
    private void removeAndCreate()
    {
        File f1,f2;
        FileWriter fw=null;
        Scanner s;
        try
        {
            f1=new File("Database.txt");
            f2=new File("Helping.txt");
            if(f1.exists())
            {
                s=new Scanner(f1);
                fw=new FileWriter(f2);
                String line; String[] tokens;
                while(s.hasNextLine())
                {
                    line= s.nextLine();
                    tokens=line.split(",");
                    if(!tokens[1].equals(username.getText()))
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
            f2=new File("Database.txt");
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        category.getItems().addAll("Supervisor","Client","Supplier","Government Regulator");
    }    

    @FXML
    private void removeUser(MouseEvent event) {
        if(Check()==true)
        {
            Alert b= new Alert(Alert.AlertType.CONFIRMATION);
            b.setTitle("Confirmation");
            b.setHeaderText("Do you want to remove the user?");
            b.setContentText("Press Ok to confirm");
            Optional<ButtonType> result=b.showAndWait();
            if(result.get()==ButtonType.OK)
            {
                removeAndCreate();
                Alert c= new Alert(Alert.AlertType.INFORMATION);
                c.setTitle("Success");
                c.setHeaderText("The user is removed successfully");
                c.setContentText("Press ok to continue");
                c.showAndWait();
            }
        }
        else
        {
            Alert a= new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Username or Category do not match");
            a.setTitle("ERROR");
            a.setContentText("Try again");
            a.showAndWait();
            ErrorText.setText("Try again");
        }
    }
    
}
