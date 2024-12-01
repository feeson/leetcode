package y24.m8.pdd.P1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static void run(long[] nums, int len){
        int cntOdd = 0;
        int cntEven = 0;
        int se = 0;
        long min = Long.MAX_VALUE;
        for (long num : nums) {
            if (num % 2 == 0){
                cntEven++;
                min = Math.min(min, num);
                if ((num / 2) % 2 == 1)
                    se++;
            } else
                cntOdd++;
        }
        if (cntEven == 0){
            System.out.println(0);
            return;
        }
        if (se != 0){
            System.out.println(cntEven);
            return;
        }
        if (cntOdd != 0){
            System.out.println(cntEven);
            return;
        }
        int res = cntEven - 1;
        while (min % 2 != 1){
            res++;
            min /= 2;
        }
        System.out.println(res);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(reader.readLine());
            String[] line = reader.readLine().split(" ");
            long[] nums = new long[len];
            for (int j = 0; j < len; j++) {
                nums[j] = Long.parseLong(line[j]);
            }
            run(nums, len);

        }
    }
}