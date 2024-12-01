package y23.m9.d22;

import java.util.Map;

/**
 给你一个整数money，表示你总共有的钱数（单位为美元）和另一个整数children，表示你要将钱分配给多少个儿童。

 你需要按照如下规则分配：


 所有的钱都必须被分配。
 每个儿童至少获得1美元。
 没有人获得 4美元。


 请你按照上述规则分配金钱，并返回 最多有多少个儿童获得 恰好8美元。如果没有任何分配方案，返回-1。



 示例 1：

 输入：money = 20, children = 3
 输出：1
 解释：
 最多获得 8 美元的儿童数为 1 。一种分配方案为：
 - 给第一个儿童分配 8 美元。
 - 给第二个儿童分配 9 美元。
 - 给第三个儿童分配 3 美元。
 没有分配方案能让获得 8 美元的儿童数超过 1 。


 示例 2：

 输入：money = 16, children = 2
 输出：2
 解释：每个儿童都可以获得 8 美元。




 提示：


 1 <= money <= 200
 2 <= children <= 30


 */
/*
https://leetcode.cn/problems/distribute-money-to-maximum-children/?envType=daily-question&envId=2023-09-22
*/
class Solutionp1 {
    public int distMoney(int money, int children) {
        if (money<children+7){
            if (money>=children)
                return 0;
            return -1;
        }
        int index=1;
        for(int i=1;i<=children;++i){
            if(money>=8)
                money-=8;
            else{
                if(i==children){
                    if (money!=4&&money!=0)
                        return i-1;
                    else
                        return  i-2;
                }else{
                    if(money>=children-i+1){
                        return i-1;
                    }else{
                        int val=children-i+1;
                        val-=money;
                        int sub=val/7;
                        if (val%7!=0)
                            sub+=1;
                        return i-1-sub;
                    }
                }
            }
        }
        if (money!=0)
            return children-1;
        else
            return children;
    }
}