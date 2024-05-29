package ExtraHW;

import java.util.Arrays;

/*
@author: Anjali Gupta
Pledge: I pledge my honor that I have abided by the Stevens Honor System - AG
 */
public class CountingSort   {
    /*
    A: array to be sorted
    B: sorted output
    C: temporary storage array
     */

    /*
    sort takes in an integer array and sorts it using the CountingSort algorithm
     */
    public static int[] sort (int[] A){
        if (A == null){
            return null;
        }
        int MAX = A[0];
        // find the max element in A
        for (int i = 1; i < A.length; i++){
            if (A[i] > MAX){
                MAX = A[i];
            }
        }
        // initialize array C to have MAX + 1 array length
        int [] C = new int [MAX + 1];

        // C[i] should contain the number of elements equal to i
        for (int j = 0; j < A.length; j++){
            C[A[j]] = C[A[j]] + 1;
        }

        // C should contain the cumulative sum of the elements in C
        for (int i = 1; i < MAX + 1; i++){
            C[i] = C[i] + C[i - 1];
        }

        int [] B = new int[A.length];

        for (int j = A.length - 1; j >= 0; j--){
            B[C[A[j]] - 1] = A[j];
            C[A[j]] = C[A[j]] - 1;
        }
        return B;
    }
}
