package y24.m3.d23.p7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        double sum = 0;
        while (m > 0){
            double e2 = (double)(m + n)/m;
            sum += 1;
            sum += e2;
            m--;
        }
        System.out.println(String.format("#.00",sum));
    }
}
