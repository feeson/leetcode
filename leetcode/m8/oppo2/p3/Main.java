package y24.m8.oppo2.p3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(reader.readLine());
        String line = reader.readLine();
        int sum = 0;
        char[] chars = line.toCharArray();
        int cnt = 0;
        for (char aChar : chars) {
            if (aChar == '?'){
                cnt++;
            }else {
                sum += (aChar - '0')%3;
            }
        }
        sum %= 3;
        if (chars[0] == '?'){
            long res = 1;
            int[] arr1 = new int[]{3,3,3};
            for (int i = 0; i < 3; i++) {
                res += arr1[i] * dfs(2, i, cnt - 1);
            }
            System.out.println(res);
        }else {
            long res = 1;
            for (int i = 0; i < 3; i++) {
                res += arr[i] * dfs(2, i, cnt - 1);
            }
            System.out.println(res);
        }
    }
    static long[] arr = new long[]{4, 3 , 3};
    static long dfs(long index, int val, long total){
        if (index == total){
            return arr[val];
        }else if (index > total){
            return 1;
        }
        long res = 1;
        for (int i = 0; i < 3; i++) {
            long dfs = dfs(index + 1, i, total);
            res += dfs*arr[val];
        }
        return res;
    }
}
