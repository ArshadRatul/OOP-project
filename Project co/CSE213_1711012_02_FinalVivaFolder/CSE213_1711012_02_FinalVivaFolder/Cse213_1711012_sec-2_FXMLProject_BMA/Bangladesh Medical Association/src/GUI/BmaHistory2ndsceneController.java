
package GUI;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;


public class BmaHistory2ndsceneController implements Initializable {

    @FXML
    private TextArea outputTextArea;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
         outputTextArea.setText("");
        File f = null;
        //FileReader fw = null;
        Scanner sc; String str=""; String[] tokens;
        try {
            f = new File("doctorRegForm.txt");
            sc = new Scanner(f);
            if(f.exists()){
                outputTextArea.appendText("Content of doctorRegForm.txt:\n");
                while(sc.hasNextLine()){
                    str+=sc.nextLine();
                  
                }
                outputTextArea.setText(str);
                
            }
            else 
                outputTextArea.setText("oops! Emp.txt does not exist...");
        } 
        catch (Exception ex) {
           
        } 
        finally {
        }        
        
    }    
    
}
