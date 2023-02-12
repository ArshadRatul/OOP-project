
package practice1;

import java.util.Scanner;


public class No3_Arithemic {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int height,base;
        double area;
        System.out.print("Enter the height: ");
        height=input.nextInt();
        System.out.print("Enter the base: ");
        base=input.nextInt();
        area=(0.5)*base*height; 
        System.out.println("Area of a triangle: "+area);
    }
}
