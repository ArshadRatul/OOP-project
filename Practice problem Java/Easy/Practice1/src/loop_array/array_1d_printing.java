//take random inputs into an array and print forward as well as backwards.
package loop_array;

import java.util.Random;
import java.util.Scanner;

public class array_1d_printing {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        Random rand=new Random();
        int n;
        System.out.print("Enter the array size: ");
        n=inp.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i <n; i++) {
            arr[i]=rand.nextInt(11);
        }
        System.out.println("Forward printing: ");
        for (int i = 0; i <n; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("\nBackward printing: ");
        for (int i =n-1; i >=0 ; i--) {
            System.out.print(arr[i]+" ");
        }
    }
}
