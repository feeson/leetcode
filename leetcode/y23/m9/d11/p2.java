package y23.m9.d11;

import java.util.*;
import java.util.function.*;

/**
 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。



 示例 1:

 输入: nums = [1,1,1,2,2,3], k = 2
 输出: [1,2]


 示例 2:

 输入: nums = [1], k = 1
 输出: [1]



 提示：


 1 <= nums.length <= 105
 k 的取值范围是 [1, 数组中不相同的元素的个数]
 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的




 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n是数组大小。

 */
/*
https://leetcode.cn/problems/top-k-frequent-elements/
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int N=0;
        for (int val:nums){
            if (!map.containsKey(val))
                map.put(val,0);
            int t=map.get(val)+1;
            map.replace(val,t);
            N=Math.max(N,t);
        }
        List<Integer>[] cnt=new List[N+1];
        map.forEach(new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer integer, Integer integer2) {
                if (cnt[integer2]==null)
                    cnt[integer2]=new ArrayList<>();
                cnt[integer2].add(integer);
            }
        });
        int[] res=new int[k];
        int wl=N;
        int wi=0;
        for (int i=0;i<k;++i){
            while (cnt[wl]==null)wl--;
            res[i]=cnt[wl].get(wi++);
            if (wi==cnt[wl].size()){
                wi=0;
                wl--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[]arr=new int[]{1,1,1,2,2,3};
        int k=2;
        System.out.println(solution.topKFrequent(arr,k));
    }
}