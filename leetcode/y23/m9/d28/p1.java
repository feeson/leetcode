package y23.m9.d28;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 给你一个下标从 0开始的二维整数数组flowers，其中flowers[i] = [starti, endi]表示第i朵花的 花期从starti到endi（都 包含）。同时给你一个下标从 0开始大小为 n的整数数组people ，people[i]是第i个人来看花的时间。

 请你返回一个大小为 n的整数数组answer，其中answer[i]是第i个人到达时在花期内花的数目。



 示例 1：



 输入：flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]
 输出：[1,2,2,2]
 解释：上图展示了每朵花的花期时间，和每个人的到达时间。
 对每个人，我们返回他们到达时在花期内花的数目。


 示例 2：



 输入：flowers = [[1,10],[3,3]], people = [3,3,2]
 输出：[2,2,1]
 解释：上图展示了每朵花的花期时间，和每个人的到达时间。
 对每个人，我们返回他们到达时在花期内花的数目。




 提示：


 1 <= flowers.length <= 5 * 104
 flowers[i].length == 2
 1 <= starti <= endi <= 109
 1 <= people.length <= 5 * 104
 1 <= people[i] <= 109


 */
/*
https://leetcode.cn/problems/number-of-flowers-in-full-bloom/?envType=daily-question&envId=2023-09-28
*/
class Solutionp1 {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for (int[]t:flowers){
            if (!map.containsKey(t[0]))
                map.put(t[0],1);
            else
                map.put(t[0],map.get(t[0])+1);
            if (!map.containsKey(t[1]+1))
                map.put(t[1]+1,-1);
            else
                map.put(t[1]+1,map.get(t[1]+1)-1);
        }
        int len=people.length;
        int[]res=Arrays.copyOf(people,len);
        Arrays.sort(people);
        int index=0;
        Map<Integer,Integer> resMap=new HashMap<>();
        int sum= 0;
        Map.Entry<Integer,Integer>[] entries = map.entrySet().toArray(new Map.Entry[0]);
        int elen=entries.length;
        loop:
        for (int i=0;i<elen;++i){
            int k=entries[i].getKey();
            int v=entries[i].getValue();
            sum+=v;
            while (people[index]<k){
                resMap.put(people[index++],0);
                if (index==len)
                    break loop;
            }
            while (i<elen-1&&people[index]>=k&&people[index]<entries[i+1].getKey()){
                resMap.put(people[index++],sum);
                if (index==len)
                    break loop;
            }
        }
        while (index<len){
            resMap.put(people[index++],0);
        }
        for (int i=0;i<len;++i){
            res[i]=resMap.get(res[i]);
        }
        return res;
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        int[][]arr1=new int[][] {{19,37},{19,38},{19,35}};
//        int[]arr=new int[]{6,7,21,1,13,37,5,37,46,43};
//        solution.fullBloomFlowers(arr1,arr);
//    }
}