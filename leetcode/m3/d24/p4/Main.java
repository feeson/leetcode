package y24.m3.d24.p4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // xb == ay
        // xy->max
        // x -> a  y -> b
        // *2 *3 *4...
        long l = 1;
        long r = 3 * (long) Integer.MAX_VALUE;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long[] line0 = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long A = line0[0];
        long B = line0[1];
        long a = line0[2];
        long b = line0[3];
        long gcd = gcd(a, b);
        if (gcd != 0) {
            a /= gcd;
            b /= gcd;
        }
        while (l <= r) {
            long mid = (l + r) / 2;
            if (a * mid == A || b * mid == B) {
                l = mid;
                break;
            } else if (a * mid > A || b * mid > B)
                r = mid - 1;
            else
                l = mid + 1;
        }
        if (a * l <= A && b * l <= B){
            System.out.println(a*l + " " + b*l);
            return;
        }
        if (a * r <= A && b * r <= B){
            System.out.println(a*r + " " + b*r);
            return;
        }
        System.out.println(0 + " " + 0);
    }
    static long gcd(long u,long v){
        if (u < v){
            u = u^v;
            v = u^v;
            u= u^v;
        }
        return v == 0 ? u : gcd(v,u % v);
    }
}

