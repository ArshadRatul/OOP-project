/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textile.factory;

import ClassesUsed.SupplierProductList;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class SupplierUpdate2Controller implements Initializable {

    @FXML
    private TableView<SupplierProductList> Tableview;
    @FXML
    private TableColumn<SupplierProductList, String> NameColumn;
    @FXML
    private TableColumn<SupplierProductList, String> SectorColumn;
    @FXML
    private TableColumn<SupplierProductList, String> QuantityColumn;
    @FXML
    private TableColumn<SupplierProductList, String> PriceColumn;
    @FXML
    private TableColumn<SupplierProductList, String> DecriptionColumn;
    
    
    public ObservableList<SupplierProductList> getinfo()
    {
        ObservableList<SupplierProductList> info = FXCollections.observableArrayList();
        info.add(new SupplierProductList("Ratul","Managing Director",12.0,12.0,"askdh"));
        File f;
        f=new File("SupplierProducts.txt");
        try {
            Scanner s= new Scanner(f);
            if (f.exists())
            {
                String line; String[] tokens;
                while(s.hasNextLine())
                {
                    line = s.nextLine();
                    tokens=line.split(",");
                    info.add(new SupplierProductList(tokens[0],tokens[1],Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3]),tokens[4] ));
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SupplierUpdate2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return info;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        NameColumn.setCellValueFactory(new PropertyValueFactory<SupplierProductList,String>("name"));
        SectorColumn.setCellValueFactory(new PropertyValueFactory<SupplierProductList,String>("sector"));
        QuantityColumn.setCellValueFactory(new PropertyValueFactory<SupplierProductList,String>("quantity"));
        PriceColumn.setCellValueFactory(new PropertyValueFactory<SupplierProductList,String>("price"));
        DecriptionColumn.setCellValueFactory(new PropertyValueFactory<SupplierProductList,String>("decription"));
        Tableview.setItems(getinfo());
    }

    @FXML
    private void DeleteButton(MouseEvent event) {
    }
}
