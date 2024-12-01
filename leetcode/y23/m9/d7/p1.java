package y23.m9.d7;

import java.math.BigInteger;
import java.util.*;

/**
 给你一个整数数组ranks，表示一些机械工的 能力值。ranksi 是第 i 位机械工的能力值。能力值为r的机械工可以在r * n2分钟内修好n辆车。

 同时给你一个整数cars，表示总共需要修理的汽车数目。

 请你返回修理所有汽车最少需要多少时间。

 注意：所有机械工可以同时修理汽车。



 示例 1：

 输入：ranks = [4,2,3,1], cars = 10
 输出：16
 解释：
 - 第一位机械工修 2 辆车，需要 4 * 2 * 2 = 16 分钟。
 - 第二位机械工修 2 辆车，需要 2 * 2 * 2 = 8 分钟。
 - 第三位机械工修 2 辆车，需要 3 * 2 * 2 = 12 分钟。
 - 第四位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
 16 分钟是修理完所有车需要的最少时间。


 示例 2：

 输入：ranks = [5,1,8], cars = 6
 输出：16
 解释：
 - 第一位机械工修 1 辆车，需要 5 * 1 * 1 = 5 分钟。
 - 第二位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
 - 第三位机械工修 1 辆车，需要 8 * 1 * 1 = 8 分钟。
 16 分钟时修理完所有车需要的最少时间。




 提示：


 1 <= ranks.length <= 105
 1 <= ranks[i] <= 100
 1 <= cars <= 106


 */
/*
https://leetcode.cn/problems/minimum-time-to-repair-cars/?envType=daily-question&envId=2023-09-07
*/
class Solution {
    public long repairCars(int[] ranks, int cars) {
        int minR = ranks[0];
        for (int r : ranks) {
            minR = Math.min(minR, r);
        }
        long left = 0;
        long right = (long) minR * cars * cars;
        while (left + 1 < right) { // 开区间
            long mid = (left + right) >> 1;
            long s = 0;
            for (int r : ranks) {
                s += Math.sqrt(mid / r);
            }
            if (s >= cars) {
                right = mid; // 满足要求
            } else {
                left = mid;
            }
        }
        return right; // 最小的满足要求的值
    }
}