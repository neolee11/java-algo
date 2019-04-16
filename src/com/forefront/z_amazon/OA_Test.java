package com.forefront.z_amazon;

import java.util.*;

public class OA_Test {

    public int[][] visited;

    public int minimumDistance(int numRows, int numColumns, List<List<Integer>> area)
    {
        visited = new int[numRows][numColumns];

        int result = calDistance(0, 0, numRows, numColumns, area);
        System.out.println("Result: " + result);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    int calDistance(int currX, int currY, int numRows, int numColumns, List<List<Integer>> area){

        if(isDestination(area, currX, currY)) return 0;

        if(visited[currX][currY] > 0) return visited[currX][currY];
//        visited[currX][currY] = 1;


        int upRouteDis = Integer.MAX_VALUE;
        if(canGoUp(numRows, numColumns, area, currX, currY)){
            upRouteDis = calDistance(currX - 1, currY , numRows, numColumns, area) + 1;
        }

        int downRouteDis = Integer.MAX_VALUE;
        if(canGoDown(numRows, numColumns, area, currX, currY)){
            downRouteDis = calDistance(currX + 1, currY , numRows, numColumns, area) + 1;
        }

        int leftRouteDis = Integer.MAX_VALUE;
        if(canGoLeft(numRows, numColumns, area, currX, currY)){
            leftRouteDis = calDistance(currX, currY - 1, numRows, numColumns, area) + 1;
        }

        int rightRouteDis = Integer.MAX_VALUE;
        if(canGoRight(numRows, numColumns, area, currX, currY)){
            rightRouteDis = calDistance(currX, currY + 1, numRows, numColumns, area) + 1;
        }

        int currMin = Integer.min(Integer.min(upRouteDis, downRouteDis), Integer.min(leftRouteDis, rightRouteDis));
        visited[currX][currY] = currMin;
        return currMin;
    }

    boolean isDestination(List<List<Integer>> area, int x, int y){
        int val = area.get(x).get(y);
        return val == 9;
    }

    boolean canGoUp(int numRows, int numColumns, List<List<Integer>> area, int x, int y){
        return x > 0 && area.get(x - 1).get(y) == 1;
    }

    boolean canGoDown(int numRows, int numColumns, List<List<Integer>> area, int x, int y){
        return (x < numRows - 1) && area.get(x + 1).get(y) == 1;
    }

    boolean canGoLeft(int numRows, int numColumns, List<List<Integer>> area, int x, int y){
        return y > 0 && area.get(x).get(y - 1) == 1;
    }

    boolean canGoRight(int numRows, int numColumns, List<List<Integer>> area, int x, int y) {
        return y < numColumns - 1 && area.get(x).get(y + 1) == 1;
    }




    List<List<Integer>> ClosestXdestinations(int numDestinations,
                                             List<List<Integer>> allLocations,
                                             int numDeliveries)
    {
        Map<Double, List<Integer>> distances = new TreeMap<Double, List<Integer>>();

        for(List<Integer> allocation : allLocations){
            int x = allocation.get(0);
            int y = allocation.get(1);
            double distance = Math.sqrt(x * x + y * y);
            distances.put(distance, allocation);
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        int count = 0;
        for (Map.Entry<Double, List<Integer>> entry : distances.entrySet()) {
            if(count < numDeliveries){
                result.add(entry.getValue());
                count++;
            }
            else{
                break;
            }
        }
        return result;
    }


}

class MedianFinder {

    private List<Integer> nums;

    /** initialize your data structure here. */
    public MedianFinder() {
        nums = new ArrayList<>();
    }

    public void addNum(int num) {
        nums.add(num);


    }

    public double findMedian() {
        if(nums.size() % 2 == 1){
            return nums.get(nums.size() / 2);
        }
        else {
            return (nums.get(nums.size() / 2) + nums.get(nums.size() / 2 + 1)) / 2;
        }

    }
}

