package y24.m8.pdd.P2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = reader.readLine().split(" ");
        int len = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        int[] nums = new int[len];
        String[] s2 = reader.readLine().split(" ");
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(s2[i]);
        }
        int border = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i]>=k){
                int val = nums[i];
                for (int j = i + 1; j < len; j++) {
                    if (nums[j] < val){
                        System.out.println(-1);
                        return;
                    }
                    val = nums[j];
                }
                break;
            }
            border = i;
        }
        if (isSeq(nums, border))
            System.out.println(0);
        int res = 0;
        while (border != -1){
            int max = Math.max(k, nums[border]);
            if (nums[border] < max){
                k = nums[border];
                nums[border] = max;
                res++;
            }
            border--;
        }
        if (isSeq(nums, len - 1))
            System.out.println(res);
        else
            System.out.println(-1);
    }
    static boolean isSeq(int[] nums, int border){
        int val = nums[0];
        for (int i = 1; i <= border; i++) {
            if (nums[i] < val)
                return false;
        }
        return true;
    }
}
