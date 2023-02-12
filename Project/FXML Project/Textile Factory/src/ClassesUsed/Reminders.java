/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesUsed;

import java.io.Serializable;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 *
 * @author Asus
 */
public class Reminders implements Serializable,Initializable{
    
    private LocalDate date;
    private String title,description;

    public Reminders(LocalDate date, String title, String description) {
        this.date = date;
        this.title = title;
        this.description = description;
    }

    public Reminders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
