package y23.m8.d30;

import java.util.*;

/**
        有一只跳蚤的家在数轴上的位置x处。请你帮助它从位置0出发，到达它的家。

        跳蚤跳跃的规则如下：


        它可以 往前 跳恰好 a个位置（即往右跳）。
        它可以 往后跳恰好 b个位置（即往左跳）。
        它不能 连续 往后跳 2 次。
        它不能跳到任何forbidden数组中的位置。


        跳蚤可以往前跳 超过它的家的位置，但是它 不能跳到负整数的位置。

        给你一个整数数组forbidden，其中forbidden[i]是跳蚤不能跳到的位置，同时给你整数a，b和x，请你返回跳蚤到家的最少跳跃次数。如果没有恰好到达 x的可行方案，请你返回 -1 。



        示例 1：

        输入：forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
        输出：3
        解释：往前跳 3 次（0 -> 3 -> 6 -> 9），跳蚤就到家了。


        示例 2：

        输入：forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
        输出：-1


        示例 3：

        输入：forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
        输出：2
        解释：往前跳一次（0 -> 16），然后往回跳一次（16 -> 7），跳蚤就到家了。




        提示：


        1 <= forbidden.length <= 1000
        1 <= a, b, forbidden[i] <= 2000
        0 <= x <= 2000
        forbidden中所有位置互不相同。
        位置x不在 forbidden中。


        */
/*
 https://leetcode.cn/problems/minimum-jumps-to-reach-home/
 */
class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x){
        Map<Integer,Integer> nOfStep=new HashMap<>();
        Queue<Integer> queue=new PriorityQueue<>();
        Set<Integer> walkedN=new HashSet<>();
        nOfStep.put(0,0);
        queue.add(0);
        int t=-1;
        Set<Integer> fbd=new HashSet<>();
        int maxFbd=-1;
        for (int val:forbidden){
            maxFbd=Math.max(maxFbd,val);
            fbd.add(val);
        }
        int LIMIT=Math.max(maxFbd+a+b,x+b);
        do {
            Integer n = queue.poll();
            if (n==x)
                break;
            if (!walkedN.contains(n)){
                walkedN.add(n);
                int nStep=nOfStep.get(n);
                t=n-b;
                if (t>0&&!walkedN.contains(t)&&!fbd.contains(t)){
                    if (nOfStep.containsKey(t)){
                        nOfStep.replace(t,Math.min(nOfStep.get(t),nStep+1));
                    }else {
                        nOfStep.put(t,nStep+1);
                    }
                    t=t+a;
                    if (t<=LIMIT&&!walkedN.contains(t)&&!fbd.contains(t)){
                        if (nOfStep.containsKey(t)){
                            nOfStep.replace(t,Math.min(nOfStep.get(t),nStep+2));
                        }else {
                            nOfStep.put(t,nStep+2);
                        }
                        queue.add(t);
                    }
                }
                t=n+a;
                if (t<=LIMIT&&!walkedN.contains(t)&&!fbd.contains(t)){
                    if (nOfStep.containsKey(t)){
                        nOfStep.replace(t,Math.min(nOfStep.get(t),nStep+1));
                    }else {
                        nOfStep.put(t,nStep+1);
                    }
                    queue.add(t);

                    t=t-b;
                    if (t>0&&!walkedN.contains(t)&&!fbd.contains(t)){
                        if (nOfStep.containsKey(t)){
                            nOfStep.replace(t,Math.min(nOfStep.get(t),nStep+2));
                        }else {
                            nOfStep.put(t,nStep+2);
                        }
                        t=t+a;
                        if (t<=LIMIT&&!walkedN.contains(t)&&!fbd.contains(t)){
                            if (nOfStep.containsKey(t)){
                                nOfStep.replace(t,Math.min(nOfStep.get(t),nStep+3));
                            }else {
                                nOfStep.put(t,nStep+3);
                            }
                            queue.add(t);
                        }
                    }
                }
            }
        }while (!queue.isEmpty());
        return nOfStep.getOrDefault(x, -1);
    }
}