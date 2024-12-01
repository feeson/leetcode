package y23.m3.d4;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums ，返回其中 按位与三元组 的数目。
 *
 * 按位与三元组 是由下标 (i, j, k) 组成的三元组，并满足下述全部条件：
 *
 * 0 <= i < nums.length
 * 0 <= j < nums.length
 * 0 <= k < nums.length
 * nums[i] & nums[j] & nums[k] == 0 ，其中 & 表示按位与运算符。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/triples-with-bitwise-and-equal-to-zero
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int countTriplets(int[] nums) {
        int len= nums.length;
        int res=0;
        Map<Integer,Integer>map=new HashMap<>();
        for (int i=0;i<len;++i){
            for (int j=0;j<len;++j){
                int num1=nums[i];
                int num2=nums[j];
                int tmp=num1&num2;
                if (map.containsKey(tmp)){
                    map.replace(tmp,map.get(tmp)+1);
                }else {
                    map.put(tmp,1);
                }
            }
        }
        for (int i=0;i<len;++i){
            for (Map.Entry<Integer,Integer> entry:map.entrySet()){
                if ((entry.getKey()&nums[i])==0){
                    res+=entry.getValue();
                }
            }
        }
        return res;
    }
}