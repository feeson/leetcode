package y24.m8.oppo2.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(reader.readLine());
        String[] line0 = reader.readLine().split(" ");
        int[] nums = new int[len];
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(line0[i]);
            Integer cnt = cntMap.computeIfAbsent(nums[i], k -> 0);
            cntMap.put(nums[i], cnt+1);
        }
        int maxSeq = 0;
        int[] cp = Arrays.copyOf(nums, len);
        Arrays.sort(cp);
        int val = 0;
        while (maxSeq < len){
            if (val >= cp[maxSeq]){
                val = cp[maxSeq] + 1;
                maxSeq++;
            }else{
                break;
            }
        }
        maxSeq = val;
        StringJoiner sj = new StringJoiner(" ");
        String mxSq = String.valueOf(maxSeq);
        for (int num : nums) {
            if (num<maxSeq){
                if (cntMap.get(num) == 1)
                    sj.add(String.valueOf(num));
                else
                    sj.add(mxSq);
            }else {
                sj.add(mxSq);
            }
        }
        System.out.println(sj);
    }
}
