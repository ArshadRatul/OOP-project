/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textile.factory;

import ClassesUsed.Reminders;
import ClassesUsed.SupplierProductList;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ManagingDirectorController implements Initializable {

    @FXML
    private TableView<Reminders> ReminderTable;
    @FXML
    private TableColumn<Reminders, LocalDate> Date;
    @FXML
    private TableColumn<Reminders, String> Title;
    @FXML
    private TableColumn<Reminders, String> Description;

    /**
     * Initializes the controller class.
     */
    public ObservableList<Reminders> settable()
    {
        ObservableList<Reminders> rem = FXCollections.observableArrayList();
        File f;
        f= new File("Reminder.bin");
        ObjectInputStream ois=null;
        try
        {
            if(f.exists())
            {
                Reminders r;
                ois = new ObjectInputStream(new FileInputStream("Reminder.bin"));
                while(true)
                {
                    r=(Reminders) ois.readObject();
                    Reminders newrem=new Reminders();
                    newrem =r;
                    rem.add(newrem);
                }
            }
            
        }catch(Exception e)
        {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }
        }
        return rem;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Date.setCellValueFactory(new PropertyValueFactory<>("date"));
        Title.setCellValueFactory(new PropertyValueFactory<>("title"));
        Description.setCellValueFactory(new PropertyValueFactory<>("description"));
        ReminderTable.setItems(settable());
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

    @FXML
    private void reminderButton(MouseEvent event) throws IOException {
        Parent newparent=FXMLLoader.load(getClass().getResource("CheckReminder.fxml"));
        Scene newsecne;
        newsecne = new Scene(newparent);
        Stage stage2=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage2.setScene(newsecne);
        stage2.show();
    }

    @FXML
    private void CheckCompanyProgressReport(MouseEvent event) throws IOException {
        
        Parent newparent=FXMLLoader.load(getClass().getResource("Check Company Progress Report.fxml"));
        Scene newsecne;
        newsecne = new Scene(newparent);
        Stage stage2=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage2.setScene(newsecne);
        stage2.show();
    }

    @FXML
    private void CheckAppointment(MouseEvent event) throws IOException {
        
        Parent newparent=FXMLLoader.load(getClass().getResource("Check Appointments.fxml"));
        Scene newsecne;
        newsecne = new Scene(newparent);
        Stage stage2=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage2.setScene(newsecne);
        stage2.show();
    }

    @FXML
    private void checkEmployeeAttendance(MouseEvent event) throws IOException {
        
        Parent newparent=FXMLLoader.load(getClass().getResource("Check Employee Attendance.fxml"));
        Scene newsecne;
        newsecne = new Scene(newparent);
        Stage stage2=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage2.setScene(newsecne);
        stage2.show();
    }

    @FXML
    private void checkFeedback(MouseEvent event) throws IOException {
        Parent newparent=FXMLLoader.load(getClass().getResource("Check Feedback.fxml"));
        Scene newsecne;
        newsecne = new Scene(newparent);
        Stage stage2=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage2.setScene(newsecne);
        stage2.show();
    }

    @FXML
    private void checkPayment(MouseEvent event) throws IOException {
        Parent newparent=FXMLLoader.load(getClass().getResource("Check Payment.fxml"));
        Scene newsecne;
        newsecne = new Scene(newparent);
        Stage stage2=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage2.setScene(newsecne);
        stage2.show();
    }
    
}
