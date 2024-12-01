package y24.m5.d4.p1;

import java.util.*;

class Solution {
    int preLen = 0;
    int[][] arr;
    TreeMap<Integer, List<Integer>> map = new TreeMap<>();
    int[][] preSum;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        arr = new int[len][3];
        for (int i = 0;i < len; ++i){
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        preSum = new int[len][2];


        for (int i = 0;i < len; ++i){
            int[] nums = arr[i];
            int s = nums[0];
            int e = nums[1];
            int p = nums[2];
            List<Integer> orDefault = map.getOrDefault(e, new ArrayList<>());
            orDefault.add(i);
            map.put(e, orDefault);

            func(s);
        }
        while (!map.isEmpty()){
            func(map.firstKey());
        }
        return preSum[preLen-1][1];
    }
    void func(int s){
        while (!map.isEmpty() && map.firstKey() <= s){
            Map.Entry<Integer, List<Integer>> firstEntry = map.pollFirstEntry();
            int k = firstEntry.getKey();
            List<Integer> list = firstEntry.getValue();
            if (k <= s){
                int max = 0;
                for (int idx :list){
                    int ss = arr[idx][0];
                    int biFind = biFind(preSum, preLen, ss);
                    max = Math.max(max, biFind + arr[idx][2]);
                }
                preSum[preLen][0] = k;
                if (preLen > 0){
                    max = Math.max(max, preSum[preLen - 1][1]);
                }
                preSum[preLen][1] = max;
                preLen++;
            }
        }
    }
    public int biFind(int[][] arr,int len, int val){
        // find max sum smaller than val
        int l = 0;
        int r = len - 1;
        while (l <= r){
            int mid = (l + r)/2;
            if (arr[mid][0] <= val){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        if (l == 0){
            return 0;
        }
        return arr[l - 1][1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = new int[]{1,2,3,3};
        int[] arr2 = new int[]{3,4,5,6};
        int[] arr3 = new int[]{50,10,40,70};
        solution.jobScheduling(arr1,arr2,arr3);
    }
}