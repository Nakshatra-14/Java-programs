//Write a function int[] insertORremove(int ar[], iint e) that first sort the passing array, then searches the passing element in the array by calling binary search function. Then it will copies the element of the array except the element found to a new array. But if the the elemnt is found in the array then it copies all the element of the array along with the new element, all in sorted order. At last the function.
// example:
//int items[] = {85, 38, 65, 95, 42}
//print(items); // 85, 38, 65, 95, 42
// int[] copy = insertORremove(items, 85);
//print(items) = 38, 42, 65, 85, 95
//print(copy) = 38, 42, 65, 85, 95

//int newCopy = insertORremove(items, 40);
//print(copy); // 38, 42, 65, 95
//print(newCopy); // 38, 40, 42, 65, 95

import java.util.*;
public class InsertOrRemoveInArray {

    public static int randInt(int lb, int ub) {
        return lb + (int) ((ub - lb + 1) * Math.random());
    }

    public static int[] genRandoms(int n, int lb, int ub) {
        int arr[], r, j;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            r = randInt(lb, ub);
            boolean f = false;
            for (j = 0; j < i; j++) {
                if (arr[j] == r) {
                    f = true;
                    break;
                }
            }

            if (f == true) {
                i--;
            } else
                arr[i] = r;
        }

        return arr;
    }

    public static int[] insertORremove(int ar[], int e) {
        int copy[];
        Arrays.sort(ar);
        int p = Arrays.binarySearch(ar, e);
        if(p < 0)       //element not found
        {
            p = - p - 1;
            copy = new int[ar.length + 1];
            for(int i = 0 ; i < p ; i++)
                copy[i] = ar[i];
            copy[p] = e;
            for(int i = p ; i < ar.length ; i++)
                copy[i + 1] = ar[i];
        }  
        else            //element found
        {
            copy = new int[ar.length - 1];
            for(int i = 0 ; i < p ; i++)
                copy[i] = ar[i];
            for(int i = p + 1 ; i < copy.length ; i++)
                copy[i - 1] = ar[i];
        }
        return copy;
    }
    public static void main(String[] args) {

    }
}
