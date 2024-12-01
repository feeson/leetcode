package y23.m9.d20;
/**
 n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。

 你需要按照以下要求，给这些孩子分发糖果：


 每个孩子至少分配到 1 个糖果。
 相邻两个孩子评分更高的孩子会获得更多的糖果。


 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。



 示例1：

 输入：ratings = [1,0,2]
 输出：5
 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。


 示例2：

 输入：ratings = [1,2,2]
 输出：4
 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。



 提示：


 n == ratings.length
 1 <= n <= 2 * 104
 0 <= ratings[i] <= 2 * 104


 */
/*
https://leetcode.cn/problems/candy/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp1 {
    public int candy(int[] ratings) {
        int len= ratings.length;
        int[]diff=new int[len];
        diff[0]=1;
        diff[len-1]=1;
        int res=0;
        for (int i=1;i<len;++i){
            if (ratings[i]>ratings[i-1])
                diff[i]=Math.max(diff[i],diff[i-1]+1);
            else
                diff[i]=Math.max(diff[i],1);
            if (ratings[len-1-i]>ratings[len-i])
                diff[len-i-1]=Math.max(diff[len-i-1],diff[len-i]+1);
            else
                diff[len-i-1]=Math.max(diff[len-i-1],1);
        }
        for (int val:diff)
            res+=val;
        return res;
    }
}