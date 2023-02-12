/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpackage;

import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class Test {
    public static void main(String[] args){
    ComplexList list = null;
    int x = 0,img = 0,real = 0;
    Scanner inp=new Scanner(System.in);
     //loop: as long as user wants [choice: 1 to add, 2 to exit]
    inp.nextInt(x);
    while(x!=2)
    {
        inp.nextInt(x);
        list.add(new Complex(img,real));
    }
    int n = s.nextInt(); //no of additional Complex numbers
    Complex[] cArr = new Complex[n];
    List.augment(cArr);
    //augment method will instantiate cArr with n Complex instances,
    //set their values, and finally merge cArr with cList of
    //ComplexList instance list
    int lower, upper;
    //get values of lower & upper from user
    List.display(lower,higher);
    //display all the Complex numbers from cList of list
    //whose real<=lower & img>=upper, using showCopmlex()
    //method of Complex class;
}
    
}
