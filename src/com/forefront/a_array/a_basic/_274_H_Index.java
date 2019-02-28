package com.forefront.a_array.a_basic;

import com.forefront.util;

/**
 Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

 According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each,
 and the other N − h papers have no more than h citations each."

 Example:

 Input: citations = [3,0,6,1,5]
 Output: 3
 Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
 received 3, 0, 6, 1, 5 citations respectively.
 Since the researcher has 3 papers with at least 3 citations each and the remaining
 two with no more than 3 citations each, her h-index is 3.
 Note: If there are several possible values for h, the maximum one is taken as the h-index.
*/

public class _274_H_Index {

    public static void solve() {

        _274_H_Index solver = new _274_H_Index();

//        int[] citations = new int[]{3,0,6,1,5};
//        int[] citations = new int[]{7,4,6,2,4};
        int[] citations = new int[]{7,7,7,7,8};

        util.printIntArray(citations);

//        int result = solver.hIndex(citations);
        int result = solver.hIndex_lc(citations);

        System.out.println("\n\nSolution");
        System.out.println(result);
    }

    public int hIndex_lc(int[] citations) {
        int n = citations.length;
        int[] counts = new int[n + 1];
        for (int c : citations) {
            if (c > n) {
                counts[n]++;
            } else {
                counts[c]++;
            }
        }
        int papers = 0;
        for (int i = n; i >= 0; i--) {
            papers += counts[i];
            if (papers >= i) {
                return i;
            }
        }
        return 0;
    }
}
