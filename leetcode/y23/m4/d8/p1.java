package y23.m4.d8;

import java.util.List;
import java.util.Map;

/**
 * 作为项目经理，你规划了一份需求的技能清单 req_skills，并打算从备选人员名单 people 中选出些人组成一个「必要团队」（ 编号为 i 的备选人员 people[i] 含有一份该备选人员掌握的技能列表）。
 * <p>
 * 所谓「必要团队」，就是在这个团队中，对于所需求的技能列表 req_skills 中列出的每项技能，团队中至少有一名成员已经掌握。可以用每个人的编号来表示团队中的成员：
 * <p>
 * 例如，团队 team = [0, 1, 3] 表示掌握技能分别为 people[0]，people[1]，和 people[3] 的备选人员。
 * 请你返回 任一 规模最小的必要团队，团队成员用人员编号表示。你可以按 任意顺序 返回答案，题目数据保证答案存在。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/smallest-sufficient-team
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    Map<String, Integer> skillToIndex;

    /**
     * //     * @param select size=reqLen [i]=j 第i项技能选j的最小人数
     *
     * @return
     */
    public static int bitCount(int n) {
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0f0f0f0f;
        n = (n + (n >>> 8)) & 0x00FF00FF;
        return n % 255;
    }

    public int[] smallestSufficientTeam(String[] req_skills,
                                        List<List<String>> people) {
        for (int i = 0; i < req_skills.length; ++i) {
            skillToIndex.put(req_skills[i], i);
        }
//        List<Integer> list = people.stream().map(val -> val.stream().map(
//                valval -> skillToIndex.get(valval)).reduce(0,
//                                                           (total, ele) -> total + ele)).toList();
        int res = (int) (Math.pow(2, req_skills.length) - 1);
        return null;
    }
//    int dfs(int[] select,int unLoad){
//        if (unLoad==-1){
//            int[] ints = Arrays.stream(select).distinct().toArray();
//            map.put(ints.length,ints);
//            return ints.length;
//        }else {
////            int min=Integer.MAX_VALUE;
////            for (int j=0;j<peoLen;++j){
////                if (peo[j][unLoad]==1){
////                    int[] nextSelect=null;
////                    nextSelect= Arrays.copyOf(select,select.length);
////                    int newUnbund=-1;
////                    for (int k=0;k<reqLen;++k){
////                        if (peo[j][k]==1)
////                            nextSelect[k]=j;
////                        if (nextSelect[k]==-1)
////                            newUnbund=k;
////                    }
////                    min=Integer.min(min,dfs(nextSelect,newUnbund));
////                }
////            }
//            return min;
//        }
//    }
}