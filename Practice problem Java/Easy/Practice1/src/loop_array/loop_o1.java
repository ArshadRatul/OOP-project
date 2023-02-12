//Taking input into an array and printing the average 
package loop_array;

import java.util.Scanner;

public class loop_o1 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n=input.nextInt();
        int sum=0;
        int[] arr1=new int[n];
        for(int i=0;i<n;i++)
        {
            System.out.print("Enter arr["+i+"]: ");
            arr1[i]=input.nextInt();
            sum += arr1[i];
        }
        print_arr(arr1);
        double ave=sum/arr1.length;
        System.out.println("average: "+ave);
    }
    
    public static void print_arr(int[] a)
    {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }
}
