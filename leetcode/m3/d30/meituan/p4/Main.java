package y24.m3.d30.meituan.p4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(reader.readLine());
        String str = reader.readLine();
        char[] charArray = str.toCharArray();
        int[] cnt = new int[26];
        for (int i = 0;i < len;++i){
            cnt[charArray[i] - 'a']++;
        }
        int max = 0;
        for (int val:cnt)
            max = Integer.max(max,val);
        int res = 0;
        for (int i = 1;i <= max;++i){
            for (int x = 0; x<26;++x){
                if (cnt[x]<i)
                    continue;
                for (int y = x + 1;y < 26; ++y){
                    if (cnt[y] < i)
                        continue;
                    res = res + fact(cnt[x],i) * fact(cnt[y],i);
                    res %= MOD;
                }
            }
        }
        System.out.println(res);
    }
    static Map<Integer,Integer> map = new HashMap<>();
    static int factorio(int x){
        if (map.containsKey(x))
            return map.get(x);
        int r = 1;
        for (int i = 1;i <= x;++i){
            r*=i;
        }
        map.put(x,r);
        return r;
    }
    static int fact(int n,int i){
        return (factorio(n)/factorio(i)/factorio(n - i))%MOD;
    }
}
