/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textile.factory;

import ClassesUsed.Reminders;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class SetReminderController implements Initializable {

    @FXML
    private DatePicker date;
    @FXML
    private TextField title;
    @FXML
    private TextArea description;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void setreminderButton(MouseEvent event) throws FileNotFoundException {
        File f=null;
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        f=new File("Reminder.bin");
        try{
            if(f.exists())
            {
                fos= new FileOutputStream(f,true);
                oos= new AppendableObjectOutputStream(fos);
            }
            else
            {
                fos= new FileOutputStream(f);
                oos= new AppendableObjectOutputStream(fos);
            }
            Reminders rem=new Reminders(date.getValue(),title.getText(),description.getText());
            oos.writeObject(rem);
            }catch(Exception e){
                
            }
        finally{
            try {
                oos.close();
                Alert a=new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("The reminder is set");
                a.setTitle("Confirmation");
                a.showAndWait();
            } catch (IOException ex) {
                Logger.getLogger(SetReminderController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @FXML
    private void BackButton(MouseEvent event) throws IOException {
        Parent newparent=FXMLLoader.load(getClass().getResource("CheckReminder.fxml"));
        Scene newsecne;
        newsecne = new Scene(newparent);
        Stage stage2=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage2.setScene(newsecne);
        stage2.show();
    }

    @FXML
    private void HomeButton(MouseEvent event) throws IOException {
        Parent NewParent = FXMLLoader.load(getClass().getResource("Managing Director.fxml"));
              Scene scene2= new Scene(NewParent);
              Stage newstage;
              newstage = (Stage)((Node)event.getSource()).getScene().getWindow();
              newstage.setTitle("Managing Director");
              newstage.setScene(scene2);
              newstage.show();
    }

    @FXML
    private void LogoutButton(MouseEvent event) throws IOException {
        Alert a= new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Alert");
        a.setHeaderText("Are you sure?");
        a.setContentText("Press \"OK\" to logout");
        Optional<ButtonType> result=a.showAndWait();
        if(result.get()==ButtonType.OK)
        {
            Parent logoutparent= FXMLLoader.load(getClass().getResource("LoginUI.fxml"));
            Scene logoutScene= new Scene(logoutparent);
            Stage newstage;
            newstage = (Stage)((Node)event.getSource()).getScene().getWindow();
            newstage.setTitle("ARSHAD TEXTILE");
            newstage.setScene(logoutScene);
            newstage.show();
        }
    }
    
}
