package y24.m8.meituan2.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = reader.readLine().split(" ");
        int a = Integer.parseInt(line1[0]);
        int b = Integer.parseInt(line1[1]);
        int c = Integer.parseInt(line1[2]);
        int d = Integer.parseInt(line1[3]);
        int n = Integer.parseInt(reader.readLine());
        int[][] bottle = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] arr = reader.readLine().split(" ");
            bottle[i][0] = Integer.parseInt(arr[0]);
            bottle[i][1] = Integer.parseInt(arr[1]);
        }
        long distance = dif(bottle[0][0], bottle[0][1], c, d);
        long dif = dif(a, b, bottle[0][0], bottle[0][1]) + distance;
        int chose = 0;
        long sum = dif;
        long cost = dif;
        for (int i = 1;i < n; ++i){
            int[] bt = bottle[i];
            distance = dif(bt[0], bt[1], c, d);
            sum += 2*distance;

            dif = dif(a, b, bt[0], bt[1]) + distance;
            if (dif < cost){
                sum -= cost;
                sum += 2 * dif(bottle[chose][0], bottle[chose][1], c, d);
                sum -= 2 * distance;
                sum += dif;
                cost = dif;
                chose = i;
            }
        }
        System.out.println(sum);
    }
    static long dif(long x, long y, long a, long b){
        return Math.abs(x - a) + Math.abs(y - b);
    }
}
