package com.forefront.a_array.a_basic;

import com.forefront.util;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 *
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
*/

public class _189_Rotate_Array {

    public static void solve() {

        _189_Rotate_Array solver = new _189_Rotate_Array();

        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;

        util.printIntArray(nums);
        solver.rotate(nums, k);

        System.out.println("\n\nSolution");
        System.out.println("k: " + k);
        util.printIntArray(nums);
    }

    public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    /**
     Let n=7n=7 and k=3k=3.

     Original List                   : 1 2 3 4 5 6 7
     After reversing all numbers     : 7 6 5 4 3 2 1
     After reversing first k numbers : 5 6 7 4 3 2 1
     After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
     */
    public void rotate_lc_1(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
