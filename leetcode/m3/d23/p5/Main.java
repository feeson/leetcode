package y24.m3.d23.p5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(reader.readLine());
        String str = reader.readLine();
        int l = 0;
        int r = 1;
        if (str.length() <2){
            System.out.println(0);
            return;
        }
        int res = 0;
        while (r < str.length()){
            if (str.charAt(l) == str.charAt(r)){
                res++;
            }
            l++;
            r++;
        }
        System.out.println(res);
    }
}
