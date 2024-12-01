package y24.m3.d18.p3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] fst = reader.readLine().split(" ");
        int len =Integer.parseInt(fst[0]);
        int n = Integer.parseInt(fst[1]);
        int cnt = 0;
        String line = reader.readLine();
        for (char c:line.toCharArray()){
            if (c == 'M' || c=='T')
                cnt++;
        }
        System.out.println(Math.min(len,cnt + n));
    }

}
