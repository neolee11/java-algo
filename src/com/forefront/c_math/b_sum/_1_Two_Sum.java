package com.forefront.c_math.b_sum;

//        Given an a_array of integers, return indices of the two numbers such that they add up to a specific target.
//
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//        Example:
//
//        Given nums = [2, 7, 11, 15], target = 9,
//
//        Because nums[0] + nums[1] = 2 + 7 = 9,
//        return [0, 1].

import com.forefront.util;

import java.util.HashMap;
import java.util.Map;

public class _1_Two_Sum {

    public static void solve() {
        int[] input = new int[]{2, 7, 11, 15};
        int target = 9;
//        int[] output = _1_Two_Sum.twoSum(input, target);
        int[] output = _1_Two_Sum.twoSum_onephase_hashmap(input, target);
        util.printIntArray(output);
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> data = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            data.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int need = target - curr;

            if (data.containsKey(need)) {
                int needIndex = data.get(need);
                if (needIndex != i) {
                    return new int[]{i, needIndex};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static int[] twoSum_onephase_hashmap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
