package y24.m3.d18.p6;

import javax.swing.text.Style;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] fst = reader.readLine().split(" ");
        int n = Integer.parseInt(fst[0]);
        int[] nums = Arrays.stream((reader.readLine().split(" "))).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        int outMin = Integer.parseInt(fst[1]);
        int outMax = Integer.parseInt(fst[2]);
        int min = Math.min(outMax - 1, -1 + n - outMin);
        int i = Math.max(outMin - 1,-1 + n - outMax);
        if ( i > min){
            System.out.println(-1);
            return;
        }
        int out = i + 1;
        while (i <= min && nums[i] == nums[i+1]){
            i++;
            out++;
            if (out > outMax){
                System.out.println(-1);
                return;
            }
        }
        if (i > min){
            System.out.println(-1);
            return;
        }
        System.out.println(nums[i]);
    }
}
