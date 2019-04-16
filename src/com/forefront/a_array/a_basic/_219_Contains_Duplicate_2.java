package com.forefront.a_array.a_basic;

import com.forefront.util;

import java.util.HashMap;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the difference between i and j is at most k.
 * <p>
 * Tags: Array, Hash Table
 * Similar Problems: (E) Contains Duplicate, (M) Contains Duplicate III
*/

public class _219_Contains_Duplicate_2 {

    public static void solve() {

        _219_Contains_Duplicate_2 solver = new _219_Contains_Duplicate_2();

        //        int[] nums = new int[]{1,2,3,1};
//        int k = 3;

        int[] nums = new int[]{1,0,1,1};
        int k = 1;

//        int[] nums = new int[]{1,2,3,1,2,3};
//        int k = 2;

        util.printIntArray(nums);
        boolean result = solver.containsDuplicate(nums, k);

        System.out.println("\n\nSolution");
        System.out.println(result);
    }

    public boolean containsDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }

        return false;
    }
}
