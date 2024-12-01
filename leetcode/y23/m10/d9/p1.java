package y23.m10.d9;

import java.util.*;

/**
 给你一个正整数num，请你将它分割成两个非负整数num1 和num2，满足：


 num1 和num2直接连起来，得到num各数位的一个排列。


 换句话说，num1 和num2中所有数字出现的次数之和等于num中所有数字出现的次数。


 num1 和num2可以包含前导 0 。


 请你返回num1 和 num2可以得到的和的 最小 值。

 注意：


 num保证没有前导 0 。
 num1 和num2中数位顺序可以与num中数位顺序不同。




 示例 1：

 输入：num = 4325
 输出：59
 解释：我们可以将 4325 分割成 num1 = 24 和 num2 = 35 ，和为 59 ，59 是最小和。


 示例 2：

 输入：num = 687
 输出：75
 解释：我们可以将 687 分割成 num1 = 68 和 num2 = 7 ，和为最优值 75 。




 提示：


 10 <= num <= 109


 */
/*
https://leetcode.cn/problems/split-with-minimum-sum/?envType=daily-question&envId=2023-10-09
*/
class Solution {
    public int splitNum(int num) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        while (num!=0){
            priorityQueue.add(num%10);
            num/=10;
        }
        int len=priorityQueue.size();
        int res=0;
        if (len%2==1){
            res+=Math.pow(10,(len-1)/2)*priorityQueue.poll();
        }
        boolean flag=true;
        int left=0;
        int right=0;
        while (!priorityQueue.isEmpty()){
            if (flag)
                left=left*10+priorityQueue.poll();
            else
                right=right*10+priorityQueue.poll();
            flag=!flag;
        }
        res+=left;
        res+=right;
        return res;

    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        int i = solution.splitNum(687);
//        System.out.println(i);
//    }
}