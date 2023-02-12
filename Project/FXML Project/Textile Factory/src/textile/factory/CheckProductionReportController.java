/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textile.factory;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class CheckProductionReportController implements Initializable {

    @FXML
    private PieChart Pie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SetTarget(MouseEvent event) {
    }

    @FXML
    private void Remark(MouseEvent event) {
    }
    
}
