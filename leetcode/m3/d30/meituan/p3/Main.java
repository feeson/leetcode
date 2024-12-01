package y24.m3.d30.meituan.p3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.StringJoiner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 1次 or 2次
        String str1 = reader.readLine();
        String str2 = reader.readLine();
        if (str1.equals(str2)){
            System.out.println(0);
            return;
        }
        // 一次
        int len = str1.length();
        int r = len - 1;
        while (r >= 0 && str1.charAt(r) == str2.charAt(r)){
            r--;
        }
        int idx = r;
        int type = 0;
        int l = 1;
        for (;l <= r; ++l){
            if (str1.charAt(l) != str1.charAt(l - 1))
                break;
        }
        if (l > r){
            System.out.println(1);
            System.out.printf("%d %d %c\n",2,idx+1,str1.charAt(r));
            return;
        }
        l = 1;
        for (;l <= r; ++l){
            if (str2.charAt(l) != str2.charAt(l - 1))
                break;
        }
        if (l > r){
            System.out.println(1);
            System.out.printf("%d %d %c\n",1,idx+1,str2.charAt(r));
            return;
        }
        System.out.println(2);
        System.out.printf("%d %d %c\n",2,r,str2.charAt(r));
        System.out.printf("%d %d %c\n",1,r,str2.charAt(r));
    }
}
