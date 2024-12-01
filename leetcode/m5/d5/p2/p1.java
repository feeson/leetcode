package y24.m5.d5.p2;

import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

class Solution {
    public int[] decrypt(int[] code, int k) {
        if (k == 0){
            Arrays.fill(code,0);
            return code;
        }
        int len = code.length;
        int[] preSum = new int[len];
        preSum[0] = code[0];
        for (int i = 1;i < len; ++i){
            preSum[i] = preSum[i - 1] + code[i];
        }
        if (k > 0){
            for (int i = 0;i < len; ++i){
                int e = i + k;
                if (e < len){
                    code[i] = preSum[e] - preSum[i];
                }else {
                    int v = preSum[len - 1] - preSum[i];
                    e -= len;
                    v += preSum[e];
                    code[i] = v;
                }
            }
        }else {
            for (int i = 0;i < len;++i){
                int s = i + k;
                if (s >= 0){
                    code[i] =preSum[i] - (s ==0?0:preSum[s - 1]);
                }else {
                    int v = i == 0?0:preSum[i - 1];
                    s = len + s;
                    v += preSum[len - 1] - preSum[s - 1];
                    code[i] = v;
                }
            }
        }
        return code;
    }
}