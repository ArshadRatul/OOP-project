
package practice1;

import java.util.Scanner;


public class No7_IfElse {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        System.out.println("Enter the value: ");
        int n=inp.nextInt();
        if(n>=35 && n<75 && n%5==0 && n%2!=0)
        {
            System.out.println("Yes");
        }
        else{System.out.println("No");}
    }
    
}
