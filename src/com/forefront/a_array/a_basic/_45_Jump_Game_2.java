package com.forefront.a_array.a_basic;

import com.forefront.util;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * Example:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 * <p>
 * You can assume that you can always reach the last index.
 */

public class _45_Jump_Game_2 {

    public static void solve() {

        _45_Jump_Game_2 solver = new _45_Jump_Game_2();

        int[] nums = new int[]{2, 3, 1, 1, 4};
//        int[] nums = new int[]{3,2,1,0,4};
//        int[] nums = new int[]{0};
        util.printIntArray(nums);

        int result = solver.jump_lc(nums);

        System.out.println("\n\nSolution");
        System.out.println(result);
    }

//    public int jump(int[] nums) {
//
//    }

    /**
     * Use last to store how far we already can reach
     * Compare i with last
     * If we run out of it, update and add 1 more step to result
     * Return if last is already bigger than or equal to the length
     * Use cur to store how far we can reach for the next step
     */
    public int jump_lc(int[] nums) {
        int step = 0;
        int last = 0; // how far we already can reach
        int cur = 0; // how far can we reach for next step

        for (int i = 0; i < nums.length; i++) {
            if (i > last) { // run out of we can reach, need one more step
                last = cur;
                step++;
                if (last >= nums.length) return step;
            }
            cur = Math.max(cur, i + nums[i]);
        }
        return step;
    }
}
