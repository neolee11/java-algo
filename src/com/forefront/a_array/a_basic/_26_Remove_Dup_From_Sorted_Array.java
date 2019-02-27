package com.forefront.a_array.a_basic;

/** Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

        Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

        Example 1:

        Given nums = [1,1,2],

        Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

        It doesn't matter what you leave beyond the returned length.
        Example 2:

        Given nums = [0,0,1,1,1,2,2,3,3,4],

        Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

        It doesn't matter what values are set beyond the returned length.
        Clarification:

        Confused why the returned value is an integer but your answer is an array?

        Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

        Internally you can think of this:

        // nums is passed in by reference. (i.e., without making a copy)
                int len = removeDuplicates(nums);

        // any modification to nums in your function would be known by the caller.
        // using the length returned by your function, it prints the first len elements.
        for (int i = 0; i < len; i++) {
            print(nums[i]);
        }
*/

import com.forefront.util;

public class _26_Remove_Dup_From_Sorted_Array {

    public static void solve() {

        _26_Remove_Dup_From_Sorted_Array solver = new _26_Remove_Dup_From_Sorted_Array();

//        int[] nums = new int[]{1, 1, 2};
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};

        util.printIntArray(nums);
        int len = solver.removeDuplicates(nums);

        System.out.println("\n\nSolution");

        System.out.println("Len: " + len);
        util.printIntArray(nums);

    }

    public int removeDuplicates(int[] nums) {

        //MY: disregard the actual occurrences of numbers, just get the distinct values
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
