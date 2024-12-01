package y23.m9.d8;

import java.util.*;

/**
 给你一个整数数组nums，请你找出并返回能被三整除的元素最大和。






 示例 1：

 输入：nums = [3,6,5,1,8]
 输出：18
 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。

 示例 2：

 输入：nums = [4]
 输出：0
 解释：4 不能被 3 整除，所以无法选出数字，返回 0。


 示例 3：

 输入：nums = [1,2,3,4,4]
 输出：12
 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。




 提示：


 1 <= nums.length <= 4 * 10^4
 1 <= nums[i] <= 10^4


 */
/*
https://leetcode.cn/problems/greatest-sum-divisible-by-three/
*/
class Solution {
    public int maxSumDivThree(int[] nums) {
        TreeMap<Integer,Integer> s1=new TreeMap<>();
        TreeMap<Integer,Integer> s2=new TreeMap<>();

        int res=0;
        int sum=0;
        for (int val:nums){
            sum+=val;
            switch (val%3){
                case 0:res+=val;break;
                case 1:{
                    if (!s1.containsKey(val))
                        s1.put(val,0);
                    s1.replace(val,s1.get(val)+1);
                    break;
                }
                default:{
                    if (!s2.containsKey(val))
                        s2.put(val,0);
                    s2.replace(val,s2.get(val)+1);
                }
            }
        }
        switch (sum%3){
            case 0:return sum;
            case 1:{
                //取一个1 /取2个2
                return func(s1,s2,sum);
            } case 2:{
                //取2个1 /取1个2
                return func(s2,s1,sum);
            }
        }
        return res;
    }
    int func(TreeMap<Integer,Integer> s1,TreeMap<Integer,Integer> s2,int sum){
        if (s1.size()==0){
            //取2个2
            if (s2.size()==0)
                return 0;
            Map.Entry<Integer, Integer> entry = s2.pollFirstEntry();
            if (entry.getValue()>1){
                return sum-=entry.getKey()*2;
            }else {
                if (s2.size()==0)
                    return 0;
                return sum-=entry.getKey()+s2.firstKey();
            }
        }else {
            int t=s1.firstKey();
            if (s2.size()==0)
                return sum-=t;
            Map.Entry<Integer, Integer> entry = s2.pollFirstEntry();
            if (entry.getValue()>1){
                return sum-=Math.min(t,entry.getKey()*2);
            }else {
                if (s2.size()==0)
                    return sum-=t;
                return sum-=Math.min(entry.getKey()+s2.firstKey(),t);
            }
        }
    }
}