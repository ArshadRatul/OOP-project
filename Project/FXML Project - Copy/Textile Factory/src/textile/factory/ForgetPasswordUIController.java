/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textile.factory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ForgetPasswordUIController implements Initializable {

    @FXML
    private TextField Name;
    @FXML
    private TextField Username;
    @FXML
    private TextField Email;
    @FXML
    private TextField MobileNo;
    @FXML
    private Button Reset;
    @FXML
    private PasswordField Password;
    @FXML
    private PasswordField ConfirmPassword;
    
    void CheckInfo()
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
                    if(tokens[0].equals(Name.getText()) && tokens[1].equals(Username.getText()) && tokens[3].equals(MobileNo.getText()) && tokens[4].equals(Email.getText()))
                    {
                        Reset.setText("Changed");
                        break;
                    }                    
                }
            }
        }catch(IOException e)
        {
            System.out.println("Error at line 63");
        }
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ResetButton(MouseEvent event) {
        CheckInfo();
    }
    
}
