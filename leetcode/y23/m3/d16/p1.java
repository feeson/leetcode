package y23.m3.d16;

import java.util.*;

/**
 * 给你一个长度为 n 的数组 nums ，该数组由从 1 到 n 的 不同 整数组成。另给你一个正整数 k 。
 *
 * 统计并返回 nums 中的 中位数 等于 k 的非空子数组的数目。
 *
 * 注意：
 *
 * 数组的中位数是按 递增 顺序排列后位于 中间 的那个元素，如果数组长度为偶数，则中位数是位于中间靠 左 的那个元素。
 * 例如，[2,3,1,4] 的中位数是 2 ，[8,4,3,5,1] 的中位数是 4 。
 * 子数组是数组中的一个连续部分。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-subarrays-with-median-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int countSubarrays(int[] nums, int k) {
        int len= nums.length;
        int res=0;
        int[]producer=new int[len];
        int tar=Integer.MAX_VALUE;
        int sum=0;
        int sumRear=0;
        Map<Integer,List<Integer>> map=new HashMap<>();
        boolean flag=true;
        for (int i=0;i<len;++i){
            if (nums[i]>k) {
                producer[i]=1;
            }
            else if (nums[i]<k) {
                producer[i]=-1;
            }
            else {
                tar=i;
                flag=false;
            }
            if (flag) {
                sum+=producer[i];
            }else {
                sumRear+=producer[i];
                if (map.containsKey(sumRear)){
                    List t1=map.get(sumRear);
                    if (i%2==0){
                        t1.set(0,(int)(t1.get(0))+1);
                    }
                    else{
                        t1.set(1,(int)(t1.get(1))+1);
                    }
                }else {
                    List t1=new ArrayList();
                    if (i%2==0){
                        t1.add(1);
                        t1.add(0);
                    }else {
                        t1.add(0);
                        t1.add(1);
                    }
                    map.put(sumRear,t1);
                }
            }
        }
        for (int i=0;i<=tar;++i){
            //可以抵消成为中位数
            if (map.containsKey(-sum)){
                List t1=map.get(-sum);
                res+=(int)t1.get(0)+(int)t1.get(1);
            }
            if (map.containsKey(1-sum)){
                List t1=map.get(1-sum);
                if (i%2==0)
                    res+=(int)t1.get(1);
                else
                    res+=(int)t1.get(0);
            }
            sum-=producer[i];
        }
        return res;
    }
}