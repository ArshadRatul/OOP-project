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
public class SignUpUserController implements Initializable {

    @FXML
    private Label ErrorText;
    @FXML
    private TextField name;
    @FXML
    private TextField password;
    @FXML
    private ComboBox category;
    @FXML
    private TextField mobile;
    @FXML
    private TextField DOB;
    @FXML
    private TextField username;
    @FXML
    private TextField email;

    /**
     * Initializes the controller class.
     */
    boolean LoginCheck()
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
                    if(tokens[1].equals(username.getText()) )
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        category.getItems().addAll("Supervisor","Client","Supplier","Government Regulator");
    }    

    @FXML
    private void SignUpButton(MouseEvent event) {
        File f; FileWriter fw=null;
        try{
            f=new File("Database.txt");
            
            if(!name.getText().equals("") && !password.getText().equals("") && !mobile.getText().equals("") && !username.getText().equals("") && !DOB.getText().equals("") && !email.getText().equals(""))
            {
                if(f.exists()){
                if(LoginCheck()==true)
                {
                    Alert b=new Alert(Alert.AlertType.WARNING);
                    b.setTitle("Warning");
                    b.setHeaderText("The username already exist");
                    b.setContentText("Try with another username");
                    b.showAndWait();
                    ErrorText.setText("The username already exist");
                }
                else
                {
                    fw=new FileWriter(f,true);
                    String user= name.getText()+","
                            +username.getText()+","
                            +password.getText()+","
                            +email.getText()+","
                            +category.getValue()+","
                            +mobile.getText()+","
                            +DOB.getText()+"\n";
                    fw.append(user);
                    name.clear();
                    username.clear();
                    password.clear();
                    email.clear();
                    mobile.clear();
                    DOB.clear();
                    category.getSelectionModel().clearSelection();
                    Alert c=new Alert(Alert.AlertType.INFORMATION);
                    c.setTitle("Information");
                    c.setHeaderText("The username is added");
                    c.setContentText("Press OK to continue");
                    c.showAndWait();
                }
                }
                else{
                    ErrorText.setText("File don't exist");
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
