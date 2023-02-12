/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesUsed;

import java.util.Random;

/**
 *
 * @author Asus
 */
public class Order {

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getSector() {
        return sector;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalprice() {
        return totalprice;
    }
    String ProductName,sector;
    double quantity,price;
    double totalprice=quantity*price;
    Random rand=new Random();
    int orderNo=rand.nextInt(1000);

    public int getOrderNo() {
        return orderNo;
    }

    public Order(String ProductName, String sector, double quantity, double price) {
        this.ProductName = ProductName;
        this.sector = sector;
        this.quantity = quantity;
        this.price = price;
    }
    
}
