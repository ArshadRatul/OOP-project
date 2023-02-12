
package practice1;

import java.util.Scanner;


public class No3_IfElse {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        float n,x;
        int a;
        System.out.print("Enter value: ");
        n=inp.nextFloat();
        a=(int) n;
        x=n-a;
        if(x==0)
        {
            System.out.println("Integer");
        }
        else
        {
            System.out.println("Float");
        }
    }
    
}
