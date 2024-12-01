package y23.m11.d11;

import java.util.*;

/**
 n 对情侣坐在连续排列的 2n个座位上，想要牵到对方的手。

 人和座位由一个整数数组 row 表示，其中 row[i] 是坐在第 i 个座位上的人的 ID。情侣们按顺序编号，第一对是(0, 1)，第二对是(2, 3)，以此类推，最后一对是(2n-2, 2n-1)。

 返回 最少交换座位的次数，以便每对情侣可以并肩坐在一起。 每次交换可选择任意两人，让他们站起来交换座位。



 示例 1:

 输入: row = [0,2,1,3]
 输出: 1
 解释: 只需要交换row[1]和row[2]的位置即可。


 示例 2:

 输入: row = [3,2,0,1]
 输出: 0
 解释: 无需交换座位，所有的情侣都已经可以手牵手了。




 提示:


 2n == row.length
 2 <= n <= 30
 n是偶数
 0 <= row[i] < 2n
 row中所有元素均无重复


 */
/*
https://leetcode.cn/problems/couples-holding-hands/?envType=daily-question&envId=2023-11-11
*/
class Solutionp1 {
    int[]pa;
    int find(int x){
        if (pa[x]==x)
            return x;
        while (pa[x]!=x){
            if (pa[pa[x]]!=pa[x])
                pa[x]=pa[pa[x]];
            x=pa[x];
        }
        return x;
    }
    void union(int i,int j){
        int paj=find(j);
        int pai=find(i);
        if (paj == pai)
            return;
        pa[paj]=pai;
    }
    public int minSwapsCouples(int[] row) {
        int len=row.length;
        pa=new int[len/2+1];
        for (int i=1;i<len/2+1;++i)
            pa[i]=i;
        int res=0;
        for (int i=0;i<len;i+=2){
            int n1=Math.min(row[i],row[i+1])/2+1 ;
            int n2=Math.max(row[i],row[i+1])/2+1 ;
            if (n1 == n2)
                continue;
            else {
                union(n2,n1);
            }
        }
        int[]cnt =new int[len/2+1];
        for (int i=1;i<len/2+1;++i){
            int i1 = find(i);
            if (i1!=i)
                cnt[i1]++;
        }
        for (int i=1;i<len/2+1;++i){
            res+=cnt[i];
        }
        return res;

    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        solution.maximumANDSum(new int[]{10,7,4,2,3,0,9,11,1,5,6,8});
//    }
}