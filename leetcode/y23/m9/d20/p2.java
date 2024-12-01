package y23.m9.d20;
/**
 给定n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



 示例 1：



 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 输出：6
 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。


 示例 2：

 输入：height = [4,2,0,3,2,5]
 输出：9




 提示：


 n == height.length
 1 <= n <= 2 * 104
 0 <= height[i] <= 105


 */
/*
https://leetcode.cn/problems/trapping-rain-water/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp2 {
    public int trap(int[] height) {
        int len=height.length;
        int res=0;
        int lastIndex=0;
        int sum=0;
        for (int i=1;i<len;++i){
            sum+=height[i]-height[i-1];
            if (sum>=0){
                int max=Math.min(height[lastIndex],height[i]);
                for (int j=lastIndex+1;j<i;++j){
                    if (max>height[j])
                        res+=max-height[j];
                }
                sum=0;
                lastIndex=i;
            }
        }
        if (sum!=0){
            int left=len-2;
            int right=len-1;
            while (left>=lastIndex){
                if (height[left]>=height[right]){
                    int max=Math.min(height[left],height[right]);
                    for (int j=left+1;j<right;++j){
                        if (max>height[j])
                            res+=max-height[j];
                    }
                    right=left;
                }
                left--;
            }
        }
        return res;
    }
}