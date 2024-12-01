package y24.m8.baidu.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringJoiner sj = new StringJoiner("\n","","\n");
        for (int i = 0; i < n; i++) {
            String[] s = reader.readLine().split(" ");
            long a = Long.parseLong(s[0]);
            long b = Long.parseLong(s[1]);
            String op = s[2];
            if (a == b){
                sj.add("=");
                continue;
            }
            switch (op){
                case "+":{
                    sj.add("=");
                    break;
                }
                case "-":{
                    if (a > b){
                        sj.add(">");
                    }else {
                        sj.add("<");
                    }
                    break;
                }
                case "*":{
                    sj.add("=");
                    break;
                }
                case "/":{
                    if (a > b){
                        sj.add(">");
                    }else {
                        sj.add("<");
                    }
                    break;
                }
                case "^":{
                    BigInteger b1 = new BigInteger(s[0]);
                    BigInteger b2 = new BigInteger(s[1]);
                    BigInteger pow = b1.pow((int) b);
                    BigInteger pow1 = b2.pow((int) a);
                    int i1 = pow.compareTo(pow1);
                    if (i1 == 0)
                        sj.add("=");
                    else if (i1 > 0){
                        sj.add(">");
                    }else {
                        sj.add("<");
                    }
                }
            }
        }
        System.out.println(sj);
    }
}
