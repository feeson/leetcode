package y23.m9.d25;

import java.util.*;

/**
 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

 请你设计并实现时间复杂度为O(n) 的算法解决此问题。



 示例 1：

 输入：nums = [100,4,200,1,3,2]
 输出：4
 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。

 示例 2：

 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 输出：9




 提示：


 0 <= nums.length <= 105
 -109 <= nums[i] <= 109


 */
/*
https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp7 {
    int[]pa;
    int find(int x){
        if (pa[x]==-1)
            return -1;
        while (pa[x]!=x){
            pa[x]=pa[pa[x]];
            x=pa[x];
        }
        return x;
    }
    void union(int i,int j){
        int pai=find(i);
        int paj=find(j);
        if (pai==paj)
            return;
        pa[paj]=pa[pai];
    }
    public int longestConsecutive(int[] nums) {
        int len=nums.length;
        pa=new int[len];
        for (int i=0;i<len;++i)
            pa[i]=i;
        Map<Integer, Integer> map=new HashMap<>();
        for (int i=0;i<len;++i){
            map.put(nums[i],i);
        }
        for (int i=0;i<len;++i){
            if (map.containsKey(nums[i]+1)){
                union(find(map.get(nums[i]+1)),find(i));
            }
        }
        int res=0;
        for (int i=0;i<len;++i){
            int index=find(i);
            res=Math.max(res,nums[index]-nums[i]+1);
        }
        return res;
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        int[]arr=new int[]{1,2,0,1};
//        System.out.println(solution.longestConsecutive(arr));
//    }
}