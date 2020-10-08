import java.util.*;
import java.io.*;

public class MergeSort{
    public static void main(String[] argv) throws IOException{
        new MergeSort().run();
    }
    PrintWriter pw;
    Scanner sc;
    int     n;
    int     i;
    int[] array;

    public void run() throws IOException{
        sc = new Scanner(new File("input.txt"));
        n = sc.nextInt();
        array = new int[n];
        i = 0;

        while (i < n){
            array[i] = sc.nextInt();
            i++;
        }

        mergeSort(array, n);
        pw = new PrintWriter(new File("output.txt"));
        for (int j = 0; j < array.length; j++){
            pw.print(array[j] + " ");
        }
        pw.close();
    }
    public static void mergeSort(int[] a, int n){
        if (n < 2)
            return;
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0;i < mid; i++)
            l[i] = a[i];

        for (int i = mid;i < n;i++)
            r[i - mid] = a[i];

        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }
    public static void merge(
            int [] a, int[] l, int[] r, int left, int right, PrintWriter pw
    )
    {
        int i;
        int j;
        int k;

        i = 0;
        j = 0;
        k = 0;
        pw.print();
        while (i < left && j < right){
            if (l[i] <= r[j]){
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left){
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
