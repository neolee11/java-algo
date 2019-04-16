package com.forefront.a_array.a_basic;

import com.forefront.util;

import javax.print.attribute.standard.NumberOfInterveningJobs;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Example 2:
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 */

public class _55_Jump_Game {

    public static void solve() {

        _55_Jump_Game solver = new _55_Jump_Game();

        int[] nums = new int[]{2, 3, 1, 1, 4};
//        int[] nums = new int[]{3,2,1,0,4};
//        int[] nums = new int[]{0};
        util.printIntArray(nums);

//        boolean result = solver.canJump_Backtracking(nums);
//        boolean result = solver.canJump_DP_TopDown(nums);
//        boolean result = solver.canJump_DP_BottomUp(nums);
        boolean result = solver.canJump_Greedy(nums);

        System.out.println("\n\nSolution");
        System.out.println(result);
    }

    public boolean canJump_DP_BottomUp(int[] nums) {

        int[] jumpIndicator = new int[nums.length]; //0 for unknown, 1 for good, -1 for bad
        jumpIndicator[nums.length - 1] = 1;

        for(int i = nums.length - 2; i >= 0; i--){
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for(int nextPosition = i + 1; nextPosition <= furthestJump; nextPosition++){
               if(jumpIndicator[nextPosition] > 0){
                   jumpIndicator[i] = 1;
                   break;
               }
            }
        }

        return jumpIndicator[0] > 0;
    }

    public boolean canJump_Greedy(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }


    public boolean canJump_DP_TopDown(int[] nums) {
        // memoization
        int[] jumpIndicator = new int[nums.length]; //0 for unknown, 1 for good, -1 for bad
        return canJumpFromPosition_DP_TopDown(0, nums, jumpIndicator);
    }

    public boolean canJumpFromPosition_DP_TopDown(int position, int[] nums, int[] jumpIndicator) {

        if (jumpIndicator[position] == 1) return true;
        if (jumpIndicator[position] == -1) return false;

        if (position == nums.length - 1) return true;

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {

            if (canJumpFromPosition_DP_TopDown(nextPosition, nums, jumpIndicator)) {
                jumpIndicator[position] = 1;
                return true;
            }
        }

        jumpIndicator[position] = -1;
        return false;
    }

    public boolean canJump_Backtracking(int[] nums) {
        return canJumpFromPosition_Backtracking(0, nums);
    }

    public boolean canJumpFromPosition_Backtracking(int position, int[] nums) {

        if (position == nums.length - 1) return true;

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition_Backtracking(nextPosition, nums)) return true;
        }

        return false;
    }
}
