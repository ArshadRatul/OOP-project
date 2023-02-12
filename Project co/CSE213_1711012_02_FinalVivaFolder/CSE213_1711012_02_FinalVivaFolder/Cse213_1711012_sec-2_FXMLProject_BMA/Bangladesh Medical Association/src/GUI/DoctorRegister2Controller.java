
package GUI;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DoctorRegister2Controller implements Initializable {

    @FXML
    private Button doctorSuhmitBtn;
    @FXML
    private TextField doctorNameTextField;
    @FXML
    private TextField doctorFathersNameTextField;
    @FXML
    private TextField doctorMothersNameTextField;
    @FXML
    private TextField doctorDivisonTextField;
    @FXML
    private TextField doctorDistrictNameTextField;
    @FXML
    private TextField doctorBranchNameTextField;
    @FXML
    private TextField doctorBranchCodeTextField;
    @FXML
    private TextField doctorPresentAddressTextField;
    @FXML
    private TextField doctorOfficePhoneTextField;
    @FXML
    private TextField doctorHomePhoneTextField;
    @FXML
    private TextField doctorMobileNoTextField;
    @FXML
    private TextField doctorPasswordTV;
    @FXML
    private TextField doctorEmailTextField;
    @FXML
    private TextField doctorBMTextField;
    @FXML
    private TextField doctorMemberShipNoTextField;
    @FXML
    private TextField doctorNationalIDTextField;
    @FXML
    private TextField doctorMemberShipTextField;
    @FXML
    private TextField doctorNationalityTextField;
    @FXML
    private TextField doctorGenderTextField;
    @FXML
    private TextField doctorBloodGroupTextField;
    @FXML
    private TextField doctorDiateOfBirthTextField;
    @FXML
    private TextField doctorReligionTextField;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
       
    }    

    @FXML
    private void doctorSubmitBtnOnClick(ActionEvent event)
    {
        
          File f = null;
        FileWriter fw = null;
        try {
            f = new File("doctorRegForm.txt");
            //fw = new FileWriter(f);
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(
            	doctorNameTextField.getText()+","
                +doctorFathersNameTextField.getText()+","	
                +doctorMothersNameTextField.getText()+","
                +doctorDivisonTextField.getText()+","
                +doctorDistrictNameTextField.getText()+","
                +doctorBranchNameTextField.getText()+","
                +doctorBranchCodeTextField.getText()+","
                +doctorPresentAddressTextField.getText()+","
                +doctorOfficePhoneTextField.getText()+","
                +doctorHomePhoneTextField.getText()+","
                +doctorMobileNoTextField.getText()+","
                +doctorPasswordTV.getText()+","
                +doctorEmailTextField.getText()+","
                +doctorBMTextField.getText()+","
                +doctorMemberShipNoTextField.getText()+","
                +doctorNationalityTextField.getText()+","
                +doctorGenderTextField.getText()+","
                +doctorBloodGroupTextField.getText()+","
                +doctorDiateOfBirthTextField.getText()+","
                +doctorReligionTextField.getText()+"\n"
              	
            );           
  
        } catch (Exception ex) {
           
        } 
        finally {
            try {
                if(fw != null) fw.close();
            } catch (IOException ex) {
               
            }
        }
        
        doctorNameTextField.setText("");
        doctorFathersNameTextField.setText("");
        doctorMothersNameTextField.setText("");
        doctorDivisonTextField.setText("");
        doctorDistrictNameTextField.setText("");
        doctorBranchNameTextField.setText("");
        doctorBranchCodeTextField.setText("");
        doctorPresentAddressTextField.setText("");
        doctorOfficePhoneTextField.setText("");
        doctorHomePhoneTextField.setText("");
        doctorMobileNoTextField.setText("");
        doctorPasswordTV.setText("");
        doctorEmailTextField.setText("");
        doctorBMTextField.setText("");
        doctorMemberShipNoTextField.setText("");
        doctorNationalityTextField.setText("");
        doctorGenderTextField.setText("");
                
        doctorBloodGroupTextField.setText("");
        
        
        doctorDiateOfBirthTextField.setText("");
        
        doctorReligionTextField.setText("");
        
        
        
        
        
        
        
        
        
    }
    
}
