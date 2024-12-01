package y23.m3.d20;

/**
 * 给定正整数 n，返回在 [1, n] 范围内具有 至少 1 位 重复数字的正整数的个数。
 *
 *
 */
class Solution {
    public int numDupDigitsAtMostN(int n) {
        int res=0;
        int times=1;
        int m=10;
        int clock=0;
        for (int i=11;i<n;i+=m) {
            res+=times;
            clock++;
            if (clock==10){
                m*=10;
                times++;
                clock=0;
            }
        }
        return res;
    }
}