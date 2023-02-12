/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesUsed;

import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class GovernmentRegulator extends User {
    
    ArrayList<CheckAppointment> list=new ArrayList();

    public GovernmentRegulator(String Name, String Username, String Password, String Email, String Category, int Mobile, date DOB) {
        super(Name, Username, Password, Email, Category, Mobile, DOB);
    }

    void checkLegalPapers()
    {
        
    }
    void updateRules()
    {
        
    }
    void checkTransactions()
    {
        
    }
    void checkTaxInformation()
    {
        
    }
}

