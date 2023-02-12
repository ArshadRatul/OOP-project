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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class LoginUIController implements Initializable {

    @FXML
    private TextField Username;
    @FXML
    private TextField Password;
    @FXML
    private Button LoginButton;
    @FXML
    private Label WrongPasswordText;
    @FXML
    private Button ForgetPasswordButton;
    @FXML
    private ComboBox Combobox;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Combobox.getItems().addAll("Managing Director","Factory Manager","Supervisor","Client","Supplier","Government Regulator");
        
    }    
    
    void ChangeUI(MouseEvent event) throws IOException
    {
          if(Combobox.getValue().equals("Managing Director"))
          {
              Parent NewParent = FXMLLoader.load(getClass().getResource("Managing Director.fxml"));
              Scene scene2= new Scene(NewParent);
              Stage newstage;
              newstage = (Stage)((Node)event.getSource()).getScene().getWindow();
              newstage.setTitle("Managing Director");
              newstage.setScene(scene2);
              newstage.show();
          }
          else if(Combobox.getValue().equals("Factory Manager"))
          {
              Parent NewParent = FXMLLoader.load(getClass().getResource("Factory Manager.fxml"));
              Scene scene2= new Scene(NewParent);
              Stage newstage;
              newstage = (Stage)((Node)event.getSource()).getScene().getWindow();
              newstage.setTitle("Factory Manager");
              newstage.setScene(scene2);
              newstage.show();
          }
          else if(Combobox.getValue().equals("Supervisor"))
          {
              Parent NewParent = FXMLLoader.load(getClass().getResource("Supervisor.fxml"));
              Scene scene2= new Scene(NewParent);
              Stage newstage;
              newstage = (Stage)((Node)event.getSource()).getScene().getWindow();
              newstage.setTitle("Supervisor");
              newstage.setScene(scene2);
              newstage.show();
          }
          else if(Combobox.getValue().equals("Client"))
          {
              Parent NewParent = FXMLLoader.load(getClass().getResource("Client.fxml"));
              Scene scene2= new Scene(NewParent);
              Stage newstage;
              newstage = (Stage)((Node)event.getSource()).getScene().getWindow();
              newstage.setTitle("Client");
              newstage.setScene(scene2);
              newstage.show();
          }
          else if(Combobox.getValue().equals("Supplier"))
          {
              Parent NewParent = FXMLLoader.load(getClass().getResource("Suppliers.fxml"));
              Scene scene2= new Scene(NewParent);
              Stage newstage;
              newstage = (Stage)((Node)event.getSource()).getScene().getWindow();
              newstage.setTitle("Supplier");
              newstage.setScene(scene2);
              newstage.show();
          }
          else if(Combobox.getValue().equals("Government Regulator"))
          {
              Parent NewParent = FXMLLoader.load(getClass().getResource("Government Regulator.fxml"));
              Scene scene2= new Scene(NewParent);
              Stage newstage;
              newstage = (Stage)((Node)event.getSource()).getScene().getWindow();
              newstage.setTitle("Government Regulator");
              newstage.setScene(scene2);
              newstage.show();
          }
          
    }
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
                    if(tokens[1].equals(Username.getText()) && tokens[2].equals(Password.getText())&& tokens[4].equals(Combobox.getValue()))
                    {
                        return true;
                    }                    
                }
            }
        }catch(IOException e)
        {
            System.out.println("Error at line 72");
        }
        return false;
    }
    void CreateFile(MouseEvent event)
    {
        File f; FileWriter fw=null;
        try{
            f=new File("Database.txt");
            if(f.exists()){
                if(LoginCheck()==true)
                {
                    ChangeUI(event);
                }
                else
                {
                    WrongPasswordText.setText("Wrong username or password");
                }
            }
            else{
                String MD="Mohammad Arsahd Hossain Ratul,Ratul,Ratul123,1930319@iub.edu.bd,Managing Director,1841501748,03/07/1999\n";
                String FM= "F.A Topu,Topu,Topu123,FM@gmail.com,Factory Manager,1841501785,24/02/1998\n";
                String SU= "Refat Ahmed,Refat,Refat123,SU@gmail.com,Supervisor,2569312145,20/08/1998\n";
                String SP= "TYB,Bristy,Bristy123,SP@gmail.com,Supplier,1236958745,16/10/1998\n";
                String CL= "Ariyan Atul,Atul,Atul123,CL@gmail.com,Client,2569312145,16/03/1998\n";
                String GR= "Nahin,Nahin,Nahin123,GR@gmail.com,Government Regulator,2569312145,25/08/1998\n";
                
                fw= new FileWriter(f);
                fw.write(MD);
                fw.append(FM);
                fw.append(SU);
                fw.append(SP);
                fw.append(CL);
                fw.append(GR);
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
            if(LoginCheck()==true)
                {
                    WrongPasswordText.setText("Success.");
                }
                else
                {
                    WrongPasswordText.setText("Wrong username or password");
                }
        }
    }

    @FXML
    private void LoginButton(MouseEvent event) {
        CreateFile(event);  
    }

    @FXML
    private void ForgetPasswordButton(MouseEvent event) {
        Parent Parentfile = null;
        try {
            Parentfile = FXMLLoader.load(getClass().getResource("ForgetPasswordUI.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(LoginUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene Forgetscene = new Scene(Parentfile);
        Stage Newscene= new Stage();
        
        Newscene.setTitle("ARSHAD TEXTILE");
        Newscene.setScene(Forgetscene);
        Newscene.showAndWait();
    }
}
