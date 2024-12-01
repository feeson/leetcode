package y22.m09.d28.p1;

/**
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/get-kth-magic-number-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int getKthMagicNumber(int k) {
        int res[]=new int[k+1];
        res[0]=1;
        for (int i=1,p1=0,p2=0,p3=0;i<k;++i){
            int a=res[p1]*3;
            int b=res[p2]*5;
            int c=res[p3]*7;
            int min = Math.min(a, Math.min(b, c));
            res[i]=min;
            if (min==a)
                p1++;
            if (min==b)
                p2++;
            if (min==c)
                p3++;
        }
        return res[k-1];
    }
}
