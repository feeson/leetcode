package y24.m8.meituan2.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = reader.readLine().split(" ");
        long a = Integer.parseInt(line1[0]);
        long b = Integer.parseInt(line1[1]);
        long c = Integer.parseInt(line1[2]);
        long k = Integer.parseInt(line1[3]);
        long[] arr = new long[]{a,b,c};
        Arrays.sort(arr);
        a = arr[0];
        b = arr[1];
        c = arr[2];
        long dif = b - a;
        long res;
        if (k > a){
            a = b;
            k -= dif;
            dif = (c - b)*2;
            if (k > dif){
                if (k % 3 == 0){
                    k /= 3;
                    a += k;
                    b += k;
                    c += k;
                }else if (k % 3 == 1){
                    k /= 3;
                    a += k + 1;
                    b += k;
                    c += k;
                }else {
                    k /= 3;
                    a += k + 1;
                    b += k + 1;
                    c += k;
                }
                long getres = getres(a, b, c);
                System.out.println(getres);
            }else {
                if (k % 2 == 0){
                    k /= 2;
                    a += k;
                    b += k;
                }else {
                    k /= 2;
                    a += k + 1;
                    b += k;
                }
                long getres = getres(a,b, c);
                System.out.println(getres);
            }
        }else {
            a += k;
            long getres = getres(a,b, c);
            System.out.println(getres);
        }
    }
    static long mod = 1_000_000_007;
    static long getres(long a, long b, long c){
        return new BigInteger(String.valueOf(a)).multiply(new BigInteger(String.valueOf(b))).multiply(new BigInteger(String.valueOf(c))).mod(new BigInteger(String.valueOf(mod))).longValue();
    }
}
