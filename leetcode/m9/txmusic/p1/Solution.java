package y24.m9.txmusic.p1;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param a int整型ArrayList
     * @return int整型ArrayList
     */
    public ArrayList<Integer> newArray (ArrayList<Integer> a) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>();
        for (Integer val : a) {
            Integer r = null;
            int times = 1;
            while (val != 0){
                if (val % 10 != 2){
                    if (r == null)
                        r = 0;
                    r += times * (val % 10);
                    times*=10;
                }
                val /= 10;
            }
            if (r != null){
                res.add(r);
            }
        }
        return res;
    }
}