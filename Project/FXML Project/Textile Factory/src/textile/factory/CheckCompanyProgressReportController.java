/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textile.factory;

import ClassesUsed.SupplierProductList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class CheckCompanyProgressReportController implements Initializable {

    @FXML
    private PieChart Piechart;
    @FXML
    private RadioButton Daily;
    @FXML
    private RadioButton Monthly;
    @FXML
    private RadioButton Weekly;
    @FXML
    private RadioButton Yearly;
    @FXML
    private TextArea Remark;
    private ToggleGroup tg;

    /**
     * Initializes the controller class.
     */
    public ObservableList<PieChart.Data> settable() throws FileNotFoundException 
    {
        File f=new File("Order.txt");
        Scanner s=new Scanner(f);
        String line; String[] tokens;
        double Machinery=0,Silk=0,Wool=0,Cotton=0,Royon=0,Polyester=0,Nylon=0;

        while(s.hasNextLine())
        {
            line=s.nextLine();
            tokens=line.split(",");
            if(tokens[0].equals("Machinery"))
            {
                ++Machinery;
            }
            else if(tokens[0].equals("Silk"))
            {
                ++Silk;
            }
            else if(tokens[0].equals("Wool"))
            {
                ++Wool;
            }
            else if(tokens[0].equals("Cotton"))
            {
                ++Cotton;
            }
            else if(tokens[0].equals("Royon"))
            {
                ++Royon;
            }
            else if(tokens[0].equals("Polyester"))
            {
                ++Polyester;
            }
            else if(tokens[0].equals("Nylon"))
            {
                ++Nylon;
            }
        }
        ObservableList<PieChart.Data> order = FXCollections.observableArrayList(
                new PieChart.Data("Machinery", Machinery),
                new PieChart.Data("Silk",Silk),
                new PieChart.Data("Wool", Wool),
                new PieChart.Data("Cotton",Cotton),
                new PieChart.Data("Royon", Royon),
                new PieChart.Data("Polyester", Polyester),
                new PieChart.Data("Nylon", Nylon)
                
        );
        return order;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tg= new ToggleGroup();
        Daily.setToggleGroup(tg);
        Monthly.setToggleGroup(tg);
        Weekly.setToggleGroup(tg);
        Yearly.setToggleGroup(tg);
        tg.selectToggle(Daily);
        try {
            Piechart.setData(settable());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CheckCompanyProgressReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
    private void remarkButton(MouseEvent event) {
        File f; FileWriter fw=null;
        try{
            f=new File("MDremark.txt");
            
            if(!Remark.equals("") )
            {
                if(f.exists()){
                    
                    fw=new FileWriter(f,true);
                    
                    fw.append(Remark.getText()+"\n");
                    Remark.clear();
                    Alert c=new Alert(Alert.AlertType.INFORMATION);
                    c.setTitle("Information");
                    c.setHeaderText("The remark is added");
                    c.setContentText("Press OK to continue");
                    c.showAndWait();
                    
                }
                else{
                    fw=new FileWriter(f,true);
                        
                        fw.append(Remark.getText()+"\n");
                        Remark.clear();
                        Alert c=new Alert(Alert.AlertType.INFORMATION);
                        c.setTitle("Information");
                        c.setHeaderText("The remark is added");
                        c.setContentText("Press OK to continue");
                        c.showAndWait();
                }
            }
            else
            {
                Alert a= new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText("Please fill all the remark field");
                a.setContentText("Press OK to continue");
                a.showAndWait();
                
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
        }
    }
    
}
