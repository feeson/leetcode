package y23.m10.d27;

import java.util.Arrays;

/**
 矩形蛋糕的高度为 h 且宽度为 w，给你两个整数数组 horizontalCuts 和 verticalCuts，其中：


 horizontalCuts[i] 是从矩形蛋糕顶部到第 i 个水平切口的距离
 verticalCuts[j] 是从矩形蛋糕的左侧到第 j 个竖直切口的距离


 请你按数组 horizontalCuts 和 verticalCuts 中提供的水平和竖直位置切割后，请你找出 面积最大 的那份蛋糕，并返回其 面积 。由于答案可能是一个很大的数字，因此需要将结果对109+ 7取余 后返回。



 示例 1：



 输入：h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
 输出：4
 解释：上图所示的矩阵蛋糕中，红色线表示水平和竖直方向上的切口。切割蛋糕后，绿色的那份蛋糕面积最大。


 示例 2：



 输入：h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
 输出：6
 解释：上图所示的矩阵蛋糕中，红色线表示水平和竖直方向上的切口。切割蛋糕后，绿色和黄色的两份蛋糕面积最大。

 示例 3：

 输入：h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
 输出：9




 提示：


 2 <= h, w <= 109
 1 <= horizontalCuts.length <= min(h - 1, 105)
 1 <= verticalCuts.length <= min(w - 1, 105)
 1 <= horizontalCuts[i] < h
 1 <= verticalCuts[i] < w
 题目数据保证 horizontalCuts 中的所有元素各不相同
 题目数据保证 verticalCuts中的所有元素各不相同


 */
/*
https://leetcode.cn/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/?envType=daily-question&envId=2023-10-27
*/
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int lenH=horizontalCuts.length;
        int lenV=verticalCuts.length;
        long maxH=horizontalCuts[0];
        long maxV=verticalCuts[0];
        for (int i=1;i<lenH;++i){
            maxH=Math.max(maxH,horizontalCuts[i]-horizontalCuts[i-1]);
        }
        maxH=Math.max(maxH,h-horizontalCuts[lenH-1]);
        for (int i=1;i<lenV;++i){
            maxV=Math.max(maxV,verticalCuts[i]-verticalCuts[i-1]);
        }
        maxV=Math.max(maxV,w-verticalCuts[lenV-1]);
        return (int) ((maxH*maxV)%(long)(1e9+7));
    }
}