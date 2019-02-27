package com.forefront.a_array.a_basic;

/**        Given an array nums and a value val, remove all instances of that value in-place and return the new length.

        Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

        The order of elements can be changed. It doesn't matter what you leave beyond the new length.

        Example 1:

        Given nums = [3,2,2,3], val = 3,

        Your function should return length = 2, with the first two elements of nums being 2.

        It doesn't matter what you leave beyond the returned length.
        Example 2:

        Given nums = [0,1,2,2,3,0,4,2], val = 2,

        Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

        Note that the order of those five elements can be arbitrary.

        It doesn't matter what values are set beyond the returned length.
        Clarification:

        Confused why the returned value is an integer but your answer is an array?

        Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

        Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
        int len = removeElement(nums, val);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
        for (int i = 0; i < len; i++) {
        print(nums[i]);
        }
 */

import com.forefront.util;

import static java.lang.System.out;

public class _27_Remove_Element {

    public static void solve() {

        _27_Remove_Element solver = new _27_Remove_Element();

//        int[] nums = new int[]{3,2,2,3};
//        int val = 3;

        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;

        out.println("To remove: " + val);
        util.printIntArray(nums);
//        int len = solver.removeElement(nums, val);
//        int len = solver.removeElement_lc1(nums, val);
        int len = solver.removeElement_lc2(nums, val);

        out.println("\n\nSolution");

        out.println("Len: " + len);
        util.printIntArray(nums);
    }

    public int removeElement(int[] nums, int val) {

        int left = 0;
        int right;

        while(left < nums.length){
            if(nums[left] == val){
                right = left;
                while(right < nums.length){
                    if(nums[right] != val){
                        int temp = nums[left];
                        nums[left] = nums[right];
                        nums[right] = temp;
                        left++;
                        break;
                    }
                    else{
                        right++;
                    }
                }

                if(right == nums.length){
                    break;
                }
            }
            else {
                left++;
            }
        }

        return left;
    }

//    private void swap(int[] nums, int indexLeft, int indexRight){
//        int temp = nums[indexLeft];
//        nums[indexLeft] = nums[indexRight];
//        nums[indexRight] = temp;
//    }

    public int removeElement_lc1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public int removeElement_lc2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
