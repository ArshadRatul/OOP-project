/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textile.factory;

import ClassesUsed.Order;
import ClassesUsed.SupplierProductList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class OrderRawMaterialsController implements Initializable {

    @FXML
    private RadioButton Mechinery;
    @FXML
    private RadioButton Silk;
    @FXML
    private RadioButton Wool;
    @FXML
    private RadioButton Cotton;
    @FXML
    private RadioButton Royon;
    @FXML
    private RadioButton Polyester;
    @FXML
    private RadioButton Nylon;
    private ToggleGroup tg;
    @FXML
    private TableView<SupplierProductList> Tableview;
    @FXML
    private TableColumn<SupplierProductList, String> ProductName;
    @FXML
    private TableColumn<SupplierProductList, String> AmountAvailable;
    @FXML
    private TableColumn<SupplierProductList, String> Price;
    @FXML
    private TableColumn<SupplierProductList, String> Description;

    /**
     * Initializes the controller class.
     */
    String Sector;
    public ObservableList<SupplierProductList> settable(String a) throws FileNotFoundException 
    {
        ObservableList<SupplierProductList> order = FXCollections.observableArrayList();
        File f=new File("SupplierProducts.txt");
        Scanner s=new Scanner(f);
        String line; String[] tokens;
        
        while(s.hasNextLine())
        {
            line=s.nextLine();
            tokens=line.split(",");
            if(tokens[1].equals(a))
            {
                Sector=tokens[1];
                order.add(new SupplierProductList(tokens[0],tokens[1],Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3]),tokens[4] ));
            }
        }
        return order;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tg= new ToggleGroup();
        Mechinery.setToggleGroup(tg);
        Silk.setToggleGroup(tg);
        Wool.setToggleGroup(tg);
        Cotton.setToggleGroup(tg);
        Royon.setToggleGroup(tg);
        Polyester.setToggleGroup(tg);
        Nylon.setToggleGroup(tg);
        
        Mechinery.setSelected(true);
        
        ProductName.setCellValueFactory(new PropertyValueFactory<>("name"));
        AmountAvailable.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        Price.setCellValueFactory(new PropertyValueFactory<>("price"));
        Description.setCellValueFactory(new PropertyValueFactory<>("decription"));
        try {
            Tableview.setItems(settable("Machinery"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrderRawMaterialsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void radioButton(ActionEvent event) {
        if(Mechinery.isSelected())
        {
            try {
            Tableview.setItems(settable("Machinery"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(OrderRawMaterialsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(Silk.isSelected())
        {
            try {
            Tableview.setItems(settable("Silk"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(OrderRawMaterialsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(Wool.isSelected())
        {
            try {
            Tableview.setItems(settable("Wool"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(OrderRawMaterialsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(Cotton.isSelected())
        {
            try {
            Tableview.setItems(settable("Cotton"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(OrderRawMaterialsController.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        else if(Royon.isSelected())
        {
            try {
            Tableview.setItems(settable("Royon"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(OrderRawMaterialsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(Polyester.isSelected())
        {
            try {
            Tableview.setItems(settable("Polyester"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(OrderRawMaterialsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(Nylon.isSelected())
        {
            try {
            Tableview.setItems(settable("Nylon"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(OrderRawMaterialsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @FXML
    private void OrderButton(MouseEvent event) throws IOException {
        
        /*Parent ParentFile= FXMLLoader.load(getClass().getResource("OrderRawMaterialsPopUp.fxml"));
        Scene scene2=new Scene(ParentFile);
        Stage newStage=new Stage();
        newStage.setScene(scene2);
        newStage.show();*/
        SupplierProductList a;
        
        a = Tableview.getSelectionModel().getSelectedItem();
        
        File f; FileWriter fw=null;
        try{
            f= new File("Order.txt");
            if(f.exists()){
                    
                    
                fw=new FileWriter(f,true);
                fw.append(Sector+",");
                fw.append(a.getName()+",");
                fw.append(Double.toString(a.getPrice())+",");
                fw.append(Double.toString(a.getQuantity())+",");
                fw.append(a.getDecription()+"\n");
                
                }
                else{
                    fw=new FileWriter(f);
                    fw.write(Sector+",");
                    fw.append(a.getName()+",");
                    fw.append(Double.toString(a.getPrice())+",");
                    fw.append(Double.toString(a.getQuantity())+",");
                    fw.append(a.getDecription()+"\n");
                }
            
        }catch(Exception e){
           
        }
        finally{
            fw.close();
            Alert b= new Alert(Alert.AlertType.INFORMATION);
            b.setHeaderText("The Order is placed");
            b.showAndWait();
        }
    }
}
