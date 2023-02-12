/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtry.fxml;

import java.io.File;
import java.io.FileNotFoundException;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class RefatController implements Initializable {

    @FXML
    private TextField ID;
    @FXML
    private TextField Password;
    @FXML
    private ComboBox Category;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Category.getItems().addAll("Driver","Guest");
    }    

    @FXML
    private void LoginButton(MouseEvent event) {
        File f=new File("Refat.txt");
        try {
            Scanner s=new Scanner(f);
            String line; String[] tokens;
            while(s.hasNextLine())
            {
                line=s.nextLine();
                tokens=line.split(",");
                if(tokens[0].equals(ID.getText()) && tokens[1].equals(Password.getText()) && tokens[3].equals(Category.getValue()))
                {
                    
                    Parent TollandPayment_UserParent = FXMLLoader.load(getClass().getResource("TollandPayment_User.fxml"));
                    Scene TollandPayment_User = new Scene(TollandPayment_UserParent);


                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                    window.setScene(TollandPayment_User);
                    window.show();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RefatController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RefatController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void SignUp(MouseEvent event) {
        FileWriter fw=null;
        try {
            File f=new File("Refat.txt");
            fw = new FileWriter(f,true);
            if(f.exists()==true)
            {
                fw.append(ID.getText()+","+Password.getText()+","+Category.getValue()+"\n");
            }
            else
            {
                fw.write(ID.getText()+","+Password.getText()+","+Category.getValue()+"\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(RefatController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ID.clear();
                Password.clear();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(RefatController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }

    
    
}
