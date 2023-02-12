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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
    @FXML
    private Label ErrorText;
    @FXML
    private Label Message;
    @FXML
    private AnchorPane midpart;
    
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
                    if(tokens[1].equals(Username.getText()) )
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
    
    void resetpassword()
    {
        File f1,f2;
        FileWriter fw=null;
        Scanner s;
        try{
            f1=new File("Database.txt");
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
                    if(tokens[0].equals(Name.getText()) && tokens[1].equals(Username.getText()) && tokens[5].equals(MobileNo.getText()) && tokens[3].equals(Email.getText()))
                    {
                        int n=0;
                        tokens[2]=Password.getText();
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ResetButton(MouseEvent event) {
        if(Password.getText().equals(ConfirmPassword.getText()))
        {
            if(Check()==true)
            {
                resetpassword();
                ErrorText.setText("You password is successfully reset");
                Message.setText("Please close the forget password window");
                Alert a=new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("You password is successfully reset");
                a.showAndWait();
            }
        }
        else
        {
            Alert b= new Alert(Alert.AlertType.ERROR);
            b.setHeaderText("Password and Confirm Pass do not match");
            b.setTitle("ERROR");
            b.setContentText("Try again");
            b.showAndWait();
            ErrorText.setText("Password and Confirm Pass do not match");
        }
    }
    
}
