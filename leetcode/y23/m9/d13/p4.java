package y23.m9.d13;

import java.util.Arrays;

/**
 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。

 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望下标数字 i 和 j 满足 i < j 且有(time[i] + time[j]) % 60 == 0。



 示例 1：

 输入：time = [30,20,150,100,40]
 输出：3
 解释：这三对的总持续时间可被 60 整除：
 (time[0] = 30, time[2] = 150): 总持续时间 180
 (time[1] = 20, time[3] = 100): 总持续时间 120
 (time[1] = 20, time[4] = 40): 总持续时间 60


 示例 2：

 输入：time = [60,60,60]
 输出：3
 解释：所有三对的总持续时间都是 120，可以被 60 整除。




 提示：


 1 <= time.length <= 6 * 104
 1 <= time[i] <= 500


 */
/*
https://leetcode.cn/problems/pairs-of-songs-with-total-durations-divisible-by-60/?envType=daily-question&envId=2023-09-13
*/
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        long[] times=new long[60];
        int len=time.length;
        for(int i=0;i<len;++i){
            times[time[i]%60]++;
        }
        long res=times[0]*(times[0]-1)/2+times[30]*(times[30]-1)/2;
        for(int i=1;i<30;++i){
            res+=times[i]*times[60-i];
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[]arr=new int[60000];
        Arrays.fill(arr,60);
        System.out.println(solution.numPairsDivisibleBy60(arr));
    }
}