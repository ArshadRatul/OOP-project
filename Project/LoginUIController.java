/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textile.factory;

import ClassesUsed.Client;
import ClassesUsed.FactoryManager;
import ClassesUsed.GovernmentRegulator;
import ClassesUsed.ManagingDirector;
import ClassesUsed.Supervisor;
import ClassesUsed.Supplier;
import ClassesUsed.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
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
        boolean ans=false;
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("Database.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User user;
            try{
                
                while(true){
                    user = (User)ois.readObject();
                    
                    if(user.getUsername().equals(Username.getText()) && user.getPassword().equals(Password.getText())&& user.getCategory().equals(Combobox.getValue()))
                    {
                        ans= true;
                    }
                }
            }//end of nested try
            catch(IOException | ClassNotFoundException e){
                //
            }//nested catch     
            
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
              
        }
        return ans;
    }
    void CreateFile(MouseEvent event)
    {
        File f; FileOutputStream fos=null;
        ObjectOutputStream oos = null;
        try{
            f=new File("Database.bin");
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
                
                User MD= new User/*ManagingDirector*/("Mohammad Arsahd Hossain Ratul","Ratul","Ratul123","1930319@iub.edu.bd","Managing Director",1841501748 );
                User FM= new User/*FactoryManager*/("F.A Topu","Topu","Topu123","FM@gmail.com","Factory Manager",1841501785);                
                User SV= new User/*Supervisor*/("Refat Ahemd","Refat","Refat123","SV@gmail.com","Supervisor",1674694920);
                User SP= new User/*Supplier*/("TYB","Bristy","Bristy123","SP@gmail.com","Supplier",1689325769);
                User CL= new User/*Client*/("MAHA","Atul","Atul123","CL@gmail.com","Client",1256889966);
                User GR= new User/*GovernmentRegulator*/("Aftab Hossain","Aftab","Aftab123","GR@gamil.com","Government Regulator",1446655833);
                fos= new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
                
                oos.writeObject(MD);
                //oos.writeObject(FM);
                //oos.writeObject(SV);
                //oos.writeObject(SP);
                //oos.writeObject(CL);
                //oos.writeObject(GR);
            }
        }catch(IOException e){
            WrongPasswordText.setText("File not found");
        }
        finally{
            try {
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(LoginUIController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(LoginCheck()==true)
                {
                    WrongPasswordText.setText("Success loading in database");
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
