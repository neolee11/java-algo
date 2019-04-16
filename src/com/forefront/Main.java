package com.forefront;

import com.forefront.a_array.d_counter._228_Summary_Ranges;
import com.forefront.z_amazon.OA_Test;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Java Algo");

        SolveArrayQuestions();
    }

    public static void SolveArrayQuestions() {
//        _27_Remove_Element.solve();
//        _26_Remove_Dup_From_Sorted_Array.solve();
//        _80_Remove_Dup_From_Sorted_Array_2.solve();
//        _277_Find_The_Celebrity.solve();
//        _189_Rotate_Array.solve();
//        _41_First_Missing_Positive.solve();
//        _299_Bulls_And_Cows.solve();
//        _134_Gas_Station.solve();
//        _53_Maximum_Subarray.solve();
//        _275_H_Index_2.solve();
//        _243_Shortest_Word_Distance.solve();
//        _217_Contains_Duplicate.solve();
//        _219_Contains_Duplicate_2.solve();
//        _55_Jump_Game.solve();
//        _45_Jump_Game_2.solve();
//        _121_Best_Time_To_Buy_And_Sell_Stock.solve();
//        _53_Maximum_Subarray.solve();
        _228_Summary_Ranges.solve();
    }

    public static void SolveMathQuestions() {
        //        _1_Two_Sum.solve();
    }

    public static void AmazonQuestion(){
        int numRows = 3;
        int numColumns = 3;
        List<List<Integer>> area = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(0);
        row1.add(0);

        List<Integer> row2 = new ArrayList<>();
        row2.add(1);
        row2.add(0);
        row2.add(0);

        List<Integer> row3 = new ArrayList<>();
        row3.add(1);
        row3.add(9);
        row3.add(1);

        area.add(row1);
        area.add(row2);
        area.add(row3);

        OA_Test a = new OA_Test();
        a.minimumDistance(numRows, numColumns, area);
    }
}
