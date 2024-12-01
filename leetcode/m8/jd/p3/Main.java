package y24.m8.jd.p3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int len;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        len = Integer.parseInt(reader.readLine());
        visit = new boolean[len * 2];
        int[][] nums = new int[2][len];
        nums[0] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        nums[1] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int step = 1;
        int pos = 0;
        long cost = nums[0][0];
        while (pos != len * 2 - 1){
            int[] poss = new int[]{right(pos), upper(pos), lower(pos)};
            for (int i = 0; i < 3; i++) {
                if (!valid(poss[i]))
                    poss[i] = -1;
            }
            int val = 0;
            int index = -1;
            if (step % 2== 0){
                // max
                val = Integer.MIN_VALUE;
                for (int i = 0; i < 3; i++) {
                    if (poss[i] != -1){
                        if (get(nums, poss[i]) > val){
                            val = get(nums, poss[i]);
                            index = i;
                        }
                    }
                }
            }else {
                val = Integer.MAX_VALUE;
                for (int i = 0; i < 3; i++) {
                    if (poss[i] != -1){
                        if (get(nums, poss[i]) < val){
                            val = get(nums, poss[i]);
                            index = i;
                        }
                        if (poss[i] == len * 2 - 1){
                            val = get(nums, poss[i]);
                            index = i;
                            break;
                        }
                    }
                }
            }
            cost += val;
            pos = poss[index];
            visit[pos] = true;
            step++;
        }
        System.out.println(cost);
    }
    static int get(int[][] nums, int pos){
        if (pos >= len){
            return nums[1][pos - len];
        }else {
            return nums[0][pos];
        }
    }
    static boolean valid(int pos){
        return pos >= 0 && pos < len * 2 && !visit[pos];
    }
    static int right(int pos){
        if (pos % len == len-1)
            return -1;
        return pos + 1;
    }
    static int upper(int pos){
        return pos - len;
    }
    static int lower(int pos){
        return pos + len;
    }
}
