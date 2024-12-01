package y24.m3.d26.p6;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        PriorityQueue<Integer> pn = new PriorityQueue<>();
        PriorityQueue<Integer> pt = new PriorityQueue<>();
        int len = nums.length;
        for (int i = 0 ;i < len;++i){
            pn.add(nums[i]);
            pt.add(target[i]);
        }
        int times = 0;
        int pool = 0;
        while (!pt.isEmpty()){
            if (pn.peek() == pt.peek()){
                pn.poll();
                pt.poll();
            }else {
                int t = pt.peek();
                int f = pn.poll();
                if (t > f){
                    if (t - f % 2 == 0){
                        if (pool > 0){
                            pool -= (t - f);
                            if (pool < 0){
                                times += (-pool)/2;
                            }
                        }else {
                            pool -= (t - f);
                            times += (t - f)/2;
                        }
                    }else {
                        int use = t + 1 - f;
                        pn.add(f + use);
                        if (pool > 0){
                        }else {

                        }
                    }
                }else {

                }
            }
        }
        return times;
    }
}
class Main{
    public static void main(String[] args) {
        int[] nums = new int[]{8,12,6};
        int[] target = new int[]{2,14,10};
        Solution solution = new Solution();
        solution.makeSimilar(nums,target);
    }
}