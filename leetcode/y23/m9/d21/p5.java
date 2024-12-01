package y23.m9.d21;
/**
 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。

 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。

 返回容器可以储存的最大水量。

 说明：你不能倾斜容器。



 示例 1：



 输入：[1,8,6,2,5,4,8,3,7]
 输出：49
 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。

 示例 2：

 输入：height = [1,1]
 输出：1




 提示：


 n == height.length
 2 <= n <= 105
 0 <= height[i] <= 104


 */
/*
https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp5 {
    public int maxArea(int[] height) {
        int len=height.length;
        int left=0;
        int right=len-1;
        int res=0;
        while (left<right){
            res=Math.max(res,(right-left)*Math.min(height[left],height[right]));
            if (height[left]<height[right]){
                int t= height[left];
                while (left<right&&height[left]<=t)left++;
            }
            else{
                int t=height[right];
                while (left<right&&height[right]<=t)right--;
            }
        }
        return res;
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        int[]arr=new int[]{1,2,4,3};
//        System.out.println(solution.maxArea(arr));
//    }
}