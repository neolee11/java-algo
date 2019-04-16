package com.forefront.a_array.d_counter;

import com.forefront.util;

import java.util.ArrayList;
import java.util.List;

/**
 Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

 Example:

 Input: [-2,1,-3,4,-1,2,1,-5,4],
 Output: 6
 Explanation: [4,-1,2,1] has the largest sum = 6.
 Follow up:

 If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

public class _53_Maximum_Subarray {

    public static void solve() {

        _53_Maximum_Subarray solver = new _53_Maximum_Subarray();

        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        int result = solver.maxSubArray(nums);
        System.out.println("Solution:\n");
        System.out.println(result);


    }

    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE, curSum = 0;
        for (int num : nums) {
            curSum = Math.max(curSum + num, num);
            res = Math.max(res, curSum);
        }

        return res;
    }
}
