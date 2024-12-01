package y23.m9.d29;
/**
 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

 给你一个整数数组flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数n ，能否在不打破种植规则的情况下种入n朵花？能则返回 true ，不能则返回 false。



 示例 1：

 输入：flowerbed = [1,0,0,0,1], n = 1
 输出：true


 示例 2：

 输入：flowerbed = [1,0,0,0,1], n = 2
 输出：false




 提示：


 1 <= flowerbed.length <= 2 * 104
 flowerbed[i] 为 0 或 1
 flowerbed 中不存在相邻的两朵花
 0 <= n <= flowerbed.length

 */
/*
https://leetcode.cn/problems/can-place-flowers/?envType=daily-question&envId=2023-09-29
*/
class Solutionp1 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int res=0;
        int len=flowerbed.length;
        if (len==1){
            return (flowerbed[0]&n)==0;
        }
        for (int i=0;i<len;++i){
            if (flowerbed[i]==0){
                if (i!=0&&i!=len-1){
                    if (flowerbed[i-1]==0&&flowerbed[i+1]==0){
                        res++;
                        flowerbed[i]=1;
                    }
                }else if (i==0){
                    if (flowerbed[i+1]==0){
                        res++;
                        flowerbed[i]=1;
                    }
                }else {
                    if (flowerbed[i-1]==0){
                        res++;
                        flowerbed[i]=1;
                    }
                }

            }else
                i++;
        }
        return res>=n;
    }
}
