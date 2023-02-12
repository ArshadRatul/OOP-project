// Take the size of the matrix and fill it with random inputs, print it.
//count the number of prime numbers in the matrix.
package arr_2d;

import java.util.Random;
import java.util.Scanner;

public class arr_2d_1 {
    public static void main(String[] args) {
        int row,column;
        Scanner inp= new Scanner(System.in);
        Random rand= new Random();
        System.out.print("Enter the number of rows: ");
        row=inp.nextInt();
        System.out.print("Enter the number of columns: ");
        column=inp.nextInt();
        int[][] arr2d= new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                arr2d[i][j]=rand.nextInt(10);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(arr2d[i][j]+" ");
            }
            System.out.println(" ");
        }
        System.out.println("Number of primes: "+NumberOfPrimes(arr2d));
    }
    public static int NumberOfPrimes(int[][] arr)
    {
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j< arr.length; j++) {
                if(checkPrime(arr[i][j])==true && arr[i][j]>1)
                {
                    sum++;
                }
            }
        }
        return sum;
    }
    public static boolean checkPrime (int a)
    {
        for (int i = 2; i <= a/2; i++) {
            if(a%i==0)
            {
                return false;
            }
        }
        return true;
    }
}
