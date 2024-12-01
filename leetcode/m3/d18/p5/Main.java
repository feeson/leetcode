package y24.m3.d18.p5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] fst = reader.readLine().split(" ");
        int len = Integer.parseInt(fst[0]);
        int q = Integer.parseInt(fst[1]);
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cnt2 = new int[len];
        int[] cnt5  = new int[len];
        for (int i=0;i<len;++i){
            int val = nums[i];
            if (val == 0)
                continue;
            while (val%2 == 0){
                cnt2[i]++;
                val/=2;
            }
            while (val%5 == 0){
                cnt5[i]++;
                val/=5;
            }
        }
        int[]l2 = new int[len+1];
        int[]l5=new int[len+1];
        int[]r2= new int[len+1];
        int[]r5=new int[len+1];
        for (int i=0;i<len;++i){
            l2[i + 1] = l2[i] + cnt2[i];
            l5[i + 1] = l5[i] + cnt5[i];
            r2[len - i - 1] =r2[len - i] + cnt2[len - i - 1];
            r5[len - i - 1] = r5[len - i] + cnt5[len - i - 1];
        }
        long res = 0;
        for (int i=0;i<len;++i){
            for (int j = len; j>= i + 1; j--){
                int t = Math.min(l2[i] + r2[j],l5[i] + r5[j]);
                if (t >= q){
                    res+= (j - i);
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
