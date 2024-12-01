package y24.m8.jd.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String S = reader.readLine();
        char[] chars = S.toCharArray();
        boolean couldDo = false;
        for (char c : chars) {
            if (c!='z'){
                couldDo = true;
                break;
            }
        }
        if (!couldDo){
            System.out.println(-1);
            return;
        }
        int len = chars.length;
        for (int i = len - 1; i >= 0; i--) {
            if (chars[i] != 'z'){
                chars[i]++;
                for (int j = i + 1; j < len; j++) {
                    chars[j] = 'a';
                }
                System.out.println(String.valueOf(chars));
                return;
            }
        }
    }
}
