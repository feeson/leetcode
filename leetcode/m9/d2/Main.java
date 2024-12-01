package y24.m9.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    String multipy(String str1, String str2){
        char[] ca1 = str1.toCharArray();
        char[] ca2 = str2.toCharArray();
        char[] res = new char[1024];
        for (int i = 0; i < ca2.length; i++) {
            for (int j = 0; j < ca1.length; j++) {
                char[] multipy = multipy(ca1[ca1.length - j - 1], ca2[ca2.length - 1 - i]);
                for (int k = 0; k < multipy.length; k++) {
                    add(res, i + j + k, multipy[multipy.length - 1 - k] - '0');
                }
            }
        }
        return String.valueOf(res);
    }
    void add(char[] res, int index, int val){
        char rc = res[index];
        if (rc == 0)
            rc = '0';
        int v = rc - '0' + val;
        res[index] = Character.forDigit(v % 10, 10);
        int offset = index + 1;
        v /= 10;
        while (v > 0){
            add(res, offset, v % 10);
            offset += 1;
            v /= 10;
        }
    }
    char[] multipy(char c1, char c2){
        int res = (c1 - '0') * (c2 - '0');
        return String.valueOf(res).toCharArray();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        String str2 = reader.readLine();
        Main main = new Main();
        String res = main.multipy(str1, str2);
        System.out.println(res);
    }
}
