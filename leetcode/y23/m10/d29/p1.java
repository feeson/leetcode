package y23.m10.d29;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。

 假设我们需要调查从基因序列start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。


 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。


 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）

 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。

 注意：起始基因序列start 默认是有效的，但是它并不一定会出现在基因库中。



 示例 1：

 输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
 输出：1


 示例 2：

 输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 输出：2


 示例 3：

 输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
 输出：3




 提示：


 start.length == 8
 end.length == 8
 0 <= bank.length <= 10
 bank[i].length == 8
 start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成


 */
/*
https://leetcode.cn/problems/minimum-genetic-mutation/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp1 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        int len= bank.length;
        bank = Arrays.copyOf(bank, len + 2);
        bank[len++]=startGene;
        bank[len++]=endGene;
        boolean flag=false;
        for (int i=0;i<len-2;++i){
            if (bank[i].equals(endGene)){
                flag=true;
                break;
            }
        }
        if (!flag)
            return -1;
        int[][] dist=new int[len][len];
        for (int i=0;i<len;++i){
            for (int j=0;j<len;++j){
                int d=distance(bank[i],bank[j]);
                if (d<=1){
                    dist[i][j]=d;
                }else {
                    dist[i][j]=-1;
                }
            }
        }
        dist[len-2][len-1]=-1;
        for (int t=0;t<len;++t){
            for (int i=0;i<len;++i){
                for (int j=0;j<len;++j){
                    if (dist[i][t]!=-1&&dist[t][j]!=-1) {
                        if (dist[i][j]==-1)
                            dist[i][j]=dist[i][t]+dist[t][j];
                        else
                            dist[i][j]=Math.min(dist[i][t]+dist[t][j],dist[i][j]);
                    }
                }
            }
        }
        return dist[len-2][len-1];
    }
    int distance(String gen1,String gen2){
        int length=0;
        for (int i=0;i<8;++i){
            if (gen1.charAt(i)!=gen2.charAt(i))
                length++;
        }
        return length;
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        String str1="AACCGGTT";
//        String str2="AAACGGTA";
//        String[]strs=new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"};
//        solution.minMutation(str1,str2,strs);
//    }
}
