//taking random number into an array and sorting it.
package loop_array;

import java.util.Random;
import java.util.Scanner;


public class arr_random {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        Random rand=new Random();
        int n;
        System.out.print("Enter the size of array: ");
        n=inp.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=rand.nextInt(10)+1;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
        bubble_sort.sorting(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        
    }
    /*static void sorting(int[] a)
    {
        int temp;
        for (int i = 0; i <a.length; i++) {
            for (int j = 0; j <a.length-1; j++) {
                if(a[j+1]>a[j])
                {
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }*/
}
