package y23.m4.d30;

import java.util.Arrays;

/**
 * 三枚石子放置在数轴上，位置分别为 a，b，c。
 *
 * 每一回合，你可以从两端之一拿起一枚石子（位置最大或最小），并将其放入两端之间的任一空闲位置。形式上，假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。那么就可以从位置 x 或者是位置 z 拿起一枚石子，并将该石子移动到某一整数位置 k 处，其中 x < k < z 且 k != y。
 *
 * 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
 *
 * 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves]
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/moving-stones-until-consecutive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[]axis=new int[3];
        axis[0]=a;
        axis[1]=b;
        axis[2]=c;
        axis=Arrays.stream(axis).sorted().toArray();
        int[]res=new int[2];
        if ((axis[1]-axis[0])==1&&(axis[2]-axis[1])==1){
            res[0]=0;
        }else if ((axis[1]-axis[0])==1||(axis[2]-axis[1])==1){
            res[0]=1;
        }else if ((axis[1]-axis[0])==2||(axis[2]-axis[1])==2){
            res[0]=1;
        }else {
            res[0]=2;
        }
        res[1]=-axis[0]-2+axis[2];
        return res;
    }
}