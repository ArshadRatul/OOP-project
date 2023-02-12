
package loop_array;

public class bubble_sort {
    public static void sorting(int[] a)
    {
        int temp;
        for (int i = 0; i <a.length; i++) {
            for (int j = 0; j <a.length-1; j++) {
                if(a[j]>a[j+1])
                {
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
}
