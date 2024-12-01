package y24.m5.d2;

import java.util.*;
import java.util.function.BinaryOperator;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int len = quality.length;
        Integer[] id = new Integer[len];
        Arrays.setAll(id, i ->i);
        Arrays.sort(id,(a,b)->wage[a]*quality[b] - wage[b]*quality[a]);

        int sum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; ++i){
            int q = quality[id[i]];
            queue.offer(q);
            sum += q;
        }
        double ans = sum * ((double) wage[id[k - 1]] / quality[id[k - 1]]);
        for (int i = k; i < len; ++i){
            int q = quality[id[i]];
            if (queue.peek() > q){
                sum -= queue.poll();
                queue.offer(q);
                sum += q;
            }
            ans = Math.min(ans, sum *((double) wage[id[i]] / q));
        }
        return ans;
    }
}

class Main{
    public static void main(String[] args) {
        int[] arr1 = new int[]{10,20,5};
        int[] arr2 = new int[]{70,50,30};
        Solution solution = new Solution();
        solution.mincostToHireWorkers(arr1,arr2,2);
    }
}