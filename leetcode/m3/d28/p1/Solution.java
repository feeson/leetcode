package y24.m3.d28.p1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        digits = Arrays.stream(digits).distinct().toArray(String[]::new);
        int lenN = 0;
        int t = n;
        while(t != 0){
            t/=10;
            lenN++;
        }
        int res =0;
        int len = digits.length;
        int[] ir = new int[lenN];
        ir[0] = len;
        for(int i = 1;i < lenN;++i){
            ir[i] = ir[i - 1]*len;
            res += ir[i - 1];
        }
        int[] narr = new int[lenN];
        t = n;
        for(int i = 0;i < lenN; ++i){
            narr[lenN - 1 - i] = t % 10;
            t/=10;
        }
        // 相同位数
        for(int i = 0 ;i < len; ++i){
            int f = f(digits, narr, ir, i, 0);
            if (f == 0)
                break;
            res += f;
        }
        return res;
    }
    int f(String[] digits,int[] narr,int[] ir,int chose,int idx){
        if (idx >= narr.length)
            return 0;
        if (digits[chose].charAt(0) - '0' > narr[idx])
            return 0;
        else if (digits[chose].charAt(0) - '0' < narr[idx]){
            if (idx == narr.length - 1){
                return 1;
            }else {
                return ir[narr.length - idx - 2];
            }
        }
        else {
            if (idx == narr.length - 1){
                return 1;
            }
            int r = 0;
            for (int i = 0;i < digits.length; ++i){
                int f = f(digits, narr, ir, i, idx + 1);
                if (f == 0)
                    break;
                r += f;
            }
            return r;
        }
    }
}
class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] ar = new String[]{"1","2","3","4","6","7","9"};
        solution.atMostNGivenDigitSet(ar,333);
    }
}