package com.forefront.z_general;

public class Sliding_Window {

    /**
    Given an array of integers of size ‘n’.
    Our aim is to calculate the maximum sum of ‘k’
    consecutive elements in the array.

     Input  : arr[] = {100, 200, 300, 400}
     k = 2
     Output : 700

     Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
     k = 4
     Output : 39
     We get maximum sum by adding subarray {4, 2, 10, 23}
     of size 4.

     Input  : arr[] = {2, 3}
     k = 3
     Output : Invalid
     There is no subarray of size 3 as size of whole
     array is 2.
    */
    public int max_sum_of_consecutive_elements(int[] arr, int k) {
        int n = arr.length;

        if (n < k)
        {
            System.out.println("Invalid");
            return -1;
        }

        // Compute sum of first window of size k
        int max_sum = 0;
        for (int i = 0; i < k; i++)
            max_sum += arr[i];

        // Compute sums of remaining windows by
        // removing first element of previous
        // window and adding last element of
        // current window.
        int window_sum = max_sum;
        for (int i = k; i < n; i++)
        {
            window_sum += arr[i] - arr[i - k];
            max_sum = Math.max(max_sum, window_sum);
        }

        return max_sum;
    }
}
