package com.forefront.a_array.a_basic;

import com.forefront.util;

/**
 Given an unsorted integer array, find the smallest missing positive integer.

 Example 1:

 Input: [1,2,0]
 Output: 3
 Example 2:

 Input: [3,4,-1,1]
 Output: 2
 Example 3:

 Input: [7,8,9,11,12]
 Output: 1
 Note:

 Your algorithm should run in O(n) time and uses constant extra space.
*/

public class _41_First_Missing_Positive {

    public static void solve() {

        _41_First_Missing_Positive solver = new _41_First_Missing_Positive();

        int[] nums = new int[]{1,2,0};
//        int[] nums = new int[]{3,4,-1,1};
//        int[] nums = new int[]{7,8,9,11,12};
        util.printIntArray(nums);
        int result = solver.firstMissingPositive(nums);

        System.out.println("\n\nSolution");
        System.out.println(result);
    }

    /**
     * Position of integer n should be n - 1 if sorted
     * Correct form [1, 2, 3, 4, ..., #, n]
     * If not in position swap it with A[A[p]-1]
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];

            while(num <= nums.length && num > 0 && num != nums[num-1] ) {
                nums[i] = nums[num - 1];
                nums[num - 1] = num;
                num = nums[i];
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1) return i + 1;
        }

        return nums.length + 1;
    }






//    public int firstMissingPositive_lc(int[] nums) {
//        if (nums == null || nums.length == 0) return 1;
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            int num = nums[i];
//            while (nums[i] <= n && nums[i] > 0 && nums[num - 1] != num) {
//                nums[i] = nums[num - 1];
//                nums[num - 1] = num;
//                num = nums[i];
//            }
//        }
//        for (int i = 0; i < n; i++)
//            if (nums[i] != i + 1) return i + 1;
//        return n + 1; // nothing in middle losing, return largest
//    }

}
