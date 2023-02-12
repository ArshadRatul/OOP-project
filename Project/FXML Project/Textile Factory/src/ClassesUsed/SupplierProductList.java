/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesUsed;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


/**
 *
 * @author Asus
 */
public class SupplierProductList implements Initializable {
    private String name,sector,decription;
    public double quantity,price;

    public String getName() {
        return name;
    }

    public String getSector() {
        return sector;
    }

    public String getDecription() {
        return decription;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
  

    public SupplierProductList(String name, String sector, double quantity, double price, String decription ) {
        this.name = name;
        this.sector = sector;
        this.decription = decription;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
