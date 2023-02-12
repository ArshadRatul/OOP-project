
package practice1;

import java.util.Scanner;

public class No2_IfElse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter input: ");
        int n=input.nextInt();
        if(n<0)
        {
            System.out.println("Negative");
        }
        else if(n>0)
        {
            System.out.println("Positive");
        }
        else
        {
            System.out.println("Neither positive nor negative");
        }
    }
    
}
