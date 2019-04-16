package com.forefront.a_array.a_basic;

import com.forefront.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * <p>
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * <p>
 * Example 1:
 * Input: [1,2,3,1]
 * Output: true
 * <p>
 * Example 2:
 * Input: [1,2,3,4]
 * Output: false
 * <p>
 * Example 3:
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */

public class _217_Contains_Duplicate {

    public static void solve() {

        _217_Contains_Duplicate solver = new _217_Contains_Duplicate();

        //        int[] nums = new int[]{1,2,3,1};
//        int[] nums = new int[]{1,2,3,4};
        int[] nums = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        util.printIntArray(nums);
        boolean result = solver.containsDuplicate(nums);

        System.out.println("\n\nSolution");
        System.out.println(result);
    }

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], 1);
            }
        }

        return false;
    }

    public boolean containsDuplicate_lc(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x : nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}
