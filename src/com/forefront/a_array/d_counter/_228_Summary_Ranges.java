package com.forefront.a_array.d_counter;

import com.ciaoshen.leetcode.util.Interval;
import com.forefront.util;

import java.util.*;

/**
 Given a sorted integer array without duplicates, return the summary of its ranges.

 Example 1:

 Input:  [0,1,2,4,5,7]
 Output: ["0->2","4->5","7"]
 Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 Example 2:

 Input:  [0,2,3,4,6,8,9]
 Output: ["0","2->4","6","8->9"]
 Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
*/

public class _228_Summary_Ranges {

    public static void solve() {
        _228_Summary_Ranges solver = new _228_Summary_Ranges();
        int[] nums = new int[]{0,1,2,4,5,7};
        util.printIntArray(nums);


        List<String> result = solver.summaryRanges(nums);
        System.out.println("Solution:\n");

        System.out.println(result);
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        if(nums.length == 0) return res;
        if(nums.length == 1) {
            res.add(Integer.toString(nums[0]));
            return res;
        }

        int left = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1] + 1) {
                if(left == i - 1){
                    res.add(Integer.toString(nums[i-1]));
                }
                else {
                    res.add(nums[left] + "->" + nums[i - 1]);
                }
                left = i;

                if(i == nums.length - 1){
                    res.add(Integer.toString(nums[i]));
                }
            }
            else {
                if(i == nums.length - 1){
                    res.add(nums[left] + "->" + nums[i]);
                }
            }
        }

        return res;
    }


}
