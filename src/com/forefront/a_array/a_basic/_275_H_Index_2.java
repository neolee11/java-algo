package com.forefront.a_array.a_basic;

import com.forefront.util;

/**
 Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

 According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

 Example:

 Input: citations = [0,1,3,5,6]
 Output: 3
 Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
 received 0, 1, 3, 5, 6 citations respectively.
 Since the researcher has 3 papers with at least 3 citations each and the remaining
 two with no more than 3 citations each, her h-index is 3.
 Note:

 If there are several possible values for h, the maximum one is taken as the h-index.

 Follow up:

 This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
 Could you solve it in logarithmic time complexity?
*/

public class _275_H_Index_2 {

    public static void solve() {

        _275_H_Index_2 solver = new _275_H_Index_2();

        int[] citations = new int[]{0,1,3,5,6};

        util.printIntArray(citations);

        int result = solver.hIndex(citations);

        System.out.println("\n\nSolution");
        System.out.println(result);
    }

    /**
     * Binary Search.
     * Think about the definition of h index: h papers that have >= h citations.
     * If randomly pick an index in the citations array, mid.
     * The # of papers have >= h citations is: array length - mid.
     * If citations[mid] = length - mid, return citations[mid].
     * If citations[mid] > length - mid, paper not enough, mid should be smaller.
     * If citations[mid] < length - mid, too many papers, mid should be larger.
     */
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int l = 0;
        int h = citations.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (citations[m] == citations.length - m) {
                return citations[m];
            } else if (citations[m] > citations.length - m) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return citations.length - l;
    }

    public int hIndex2(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int l = 0;
        int h = citations.length;
        int mid;
        while (l < h) {
            mid = l + (h - l) / 2;
            if (citations[mid] == citations.length - mid) {
                return citations[mid];
            } else if (citations[mid] > citations.length - mid) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return citations.length - h;
    }
}
