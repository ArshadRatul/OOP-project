/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesUsed;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Asus
 */
public class Logout {

    public void logout(MouseEvent event) throws IOException
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
