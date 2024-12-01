package y24.m8.meituan.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main{
    static int gcd(int m, int n){
        if (m < n){
            int t = m;
            m = n;
            n = t;
        }
        return n==0?m:gcd(n,m%n);
    }
    static boolean isPrime(int n) {
        if(n <= 3 && n > 1) {
            return true;
        }
        //不在6的倍数两侧的一定不是素数
        if((n % 6 != 1) && (n % 6 != 5)) {
            return false;
        }
        for(int i = 5; i <= Math.sqrt(n); i+= 6) {
            if(n % i == 0 || n %(i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        Set<Integer> prims = new HashSet<>();
        int max = 2;

        String str = reader.readLine();
        while (str != null){
            int n = Integer.parseInt(str);
            for (int i = max; i <= n; ++i){
                if (isPrime(i)){
                    prims.add(i);
                }
            }
            max = Math.max(max, n + 1);
            for (int i = 2; i <=n ;++i){
                if (prims.contains(gcd(n, i))){
                    System.out.println(i);
                    break;
                }
            }

            str = reader.readLine();
        }
    }
}