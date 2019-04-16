package com.forefront.a_array.a_basic;

import com.forefront.util;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */

public class _121_Best_Time_To_Buy_And_Sell_Stock {

    public static void solve() {

        _121_Best_Time_To_Buy_And_Sell_Stock solver = new _121_Best_Time_To_Buy_And_Sell_Stock();

        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
//        int[] nums = new int[]{7, 6, 4, 3, 1};
        util.printIntArray(nums);

        int result = solver.maxProfit_onepass(nums);
//        int result = solver.maxProfit_bruteforce(nums);

        System.out.println("\n\nSolution");
        System.out.println(result);
    }

    public int maxProfit_onepass(int[] prices){
        if (prices.length < 2) return 0;
        int minVal = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++){
            int currProfit = prices[i] - minVal;
            if(currProfit > maxProfit) maxProfit = currProfit;

            if(prices[i] < minVal) minVal = prices[i];
        }

        return maxProfit;

//        maxDiff(array[1..n], min) = max(maxDiff(array[1..n-1], min), array[n] - min).
    }

    public int maxProfit_bruteforce(int[] prices) {

        if (prices.length < 2) return 0;

        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > max) max = profit;
            }
        }

        return max;
    }
}
