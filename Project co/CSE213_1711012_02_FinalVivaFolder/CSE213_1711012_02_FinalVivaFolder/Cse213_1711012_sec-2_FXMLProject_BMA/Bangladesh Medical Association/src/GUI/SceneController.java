
package GUI;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class SceneController implements Initializable {

    @FXML
    private ComboBox  userTypeComboBox;
    @FXML
    private Button registerBtn;
    @FXML
    private Button loginBtn;
    @FXML
    private TextArea ouputTextArea;
    @FXML
    private TextField userIDTV;
    @FXML
    private TextField passIdTV;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
      userTypeComboBox.getItems().addAll("Doctor","Hospital","Commitee","Ministry of Health","Branch");
        userTypeComboBox.setValue("Doctor"); 
    }    

    @FXML
    private void registerBtnOnClick(ActionEvent event)
    {
         File f = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("login.bin");
            if(f.exists()) fos = new FileOutputStream(f,true);
            else fos = new FileOutputStream(f);
            
            bos = new BufferedOutputStream(fos);
            dos = new DataOutputStream(bos);
            //dos = new DataOutputStream(fos);
            
           
            dos.writeUTF(userIDTV.getText());
            dos.writeUTF(passIdTV.getText());
            dos.writeUTF(userTypeComboBox.getValue().toString());
          

        } catch (Exception ex) {
    
        } finally {
            try {
                if(dos != null) dos.close();
            } catch (Exception ex) {
                
            }
        }      
    }

    @FXML
    private void logInBtnOnClick(ActionEvent event)
    {
        String id = userIDTV.getText().toString();
        String pass = passIdTV.getText().toString();
        String type = userTypeComboBox.getValue().toString();
        
        
        File f = null;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
        String str="";
        try {
            f = new File("login.bin");
            if(!f.exists()){
                ouputTextArea.setText("Oops! login.bin binary file does not exist...");
            }
            else{
                
                fis = new FileInputStream(f);
               
                dis = new DataInputStream(fis);
               
                while(true){
                    
                      String ID=  dis.readUTF();
                       String PASS= dis.readUTF();
                      String TYPE=  dis.readUTF();
                      
                      if(ID.equals(id) && PASS.equals(pass) && TYPE.equals(type))
                      {
                          ouputTextArea.setText("Login Successfull!");
                          
                          if(TYPE.equals("Doctor"))
                          {
                               Parent scene2Parent = FXMLLoader.load(getClass().getResource("doctor1stScene.fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                   window.setScene(scene2);
                      window.show();
                              
                          }
                          
                          else if(TYPE.equals("Hospital"))
                          {
                                   Parent scene2Parent = FXMLLoader.load(getClass().getResource("hospital2ndScence.fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                   window.setScene(scene2);
                      window.show();
                              
                          }    
                          else if(TYPE.equals("Commitee"))
                          {
                                   Parent scene2Parent = FXMLLoader.load(getClass().getResource("committee2ndScene.fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                   window.setScene(scene2);
                      window.show();
                              
                          }
                          
                       
                          else if(TYPE.equals("Ministry of Health"))
                          {
                           Parent scene2Parent = FXMLLoader.load(getClass().getResource("ministryOfHealth2ndScene.fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                   window.setScene(scene2);
                      window.show();
                              
                          }
                          else if(TYPE.equals("Branch"))
                          {
                           Parent scene2Parent = FXMLLoader.load(getClass().getResource("branchwisemember2ndScene.fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                          Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                          window.setScene(scene2);
                          window.show();
                              
                          }
                          
                          
                        
                          
                          break;
                      }
                      
                    
                      
                       
                  
                }//while
                //outputTextArea.setText(str);
            }//else
        } catch (Exception ex) {
            ouputTextArea.setText("Login Failed!");

        } finally {
          
        }
        
        
    }

    
    

   
}
