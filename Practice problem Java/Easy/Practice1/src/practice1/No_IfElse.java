
package practice1;

import java.util.Scanner;
public class No_IfElse {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        float a,b,c;
        System.out.println("Enter the first value: ");
        a=inp.nextFloat();
        System.out.println("Enter the second value: ");
        b=inp.nextFloat();
        System.out.println("Enter the third value: ");
        c=inp.nextFloat();
        if(a>b)
        {
            if(c>b)
            {
                if(a>c)
                {
                    System.out.println("Largest: "+a);
                    System.out.println("Smallest: "+b);
                }
                else
                {
                    System.out.println("Largest: "+c);
                    System.out.println("Smallest: "+b);
                }
            }
            else
            {
                System.out.println("Largest: "+a);
                System.out.println("Smallest: "+c);
            }
        }
        else
        {
            if(c<b)
            {
                if(a>c)
                {
                    System.out.println("Largest: "+b);
                    System.out.println("Smallest: "+c);
                }
                else
                {
                    System.out.println("Largest: "+b);
                    System.out.println("Smallest: "+a);
                }
            }
            else
            {
                System.out.println("Largest: "+c);
                System.out.println("Smallest: "+a);
            }
        }
    }
    
}
