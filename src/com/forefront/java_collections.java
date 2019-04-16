package com.forefront;

import java.util.*;

/**
 * Array sort
 * Collection sort, Iterator
 * <p>
 * List: ArrayList (common), LinkedList
 * <p>
 * Set: HashSet, EnumSet
 * SortedSet / NavigableSet: TreeSet
 * <p>
 * Queue: ArrayDeque
 * Deque: ArrayDeque, PriorityQueue, LinkedList (should use ArrayDeque instead)
 * Stack: Stack (deprecated, should use ArrayDeque instead)
 * <p>
 * Map: HashMap, LinkedHashMap, EnumMap
 * SortedMap: TreeMap
 */

public class java_collections {

    public static void test() {

        List<Integer> listInt = new ArrayList<>();

        Set<String> strSet = new HashSet<>();
        strSet.add("test");
        strSet.add("test");

        NavigableSet<String> navigableSet = new TreeSet<>();
        navigableSet.add("test");
        navigableSet.add("test1");
        navigableSet.add("test2");
        navigableSet.descendingSet();

        Queue<Integer> testPrioQueue = new PriorityQueue<>();
        Deque<Integer> testArrayDeque = new ArrayDeque<>();

        testPrioQueue.p
        Stack<Integer> testStack = new Stack<>();

        Map<Integer, String> testMap = new HashMap<>();
        Iterator it = testMap.entrySet().iterator();

        TreeMap<Integer, String> testTreeMap = new TreeMap<>();
        Map<Integer, String> testTreeMapA = new LinkedHashMap<Integer, String>();
//        testTreeMap.put();
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(count::get));

        for (int n : count.keySet()) {
            pq.offer(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;
    }


}
