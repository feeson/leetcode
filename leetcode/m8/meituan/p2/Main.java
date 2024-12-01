package y24.m8.meituan.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(reader.readLine());
        ArrayList<Integer> arr = new ArrayList<>(len);
        String valLine = reader.readLine();
        String[] split = valLine.split(" ");
        List<Integer> nums = new ArrayList<>();
        for (String s : split) {
            arr.add(Integer.parseInt(s));
        }
        arr.sort(Comparator.naturalOrder());
        int sum = arr.stream().reduce((v1, v2) -> v1 + v2).get();
        int val = sum / len;
        int v2 = sum % len;
        int l = len - v2;
        for (int i = 0;i < l; ++i){
            nums.add(val);
        }
        for (int i = 0;i < v2; ++i){
            nums.add(val + 1);
        }
        int res = 0;
        for (int i = 0;i < len; ++i){
            if (arr.get(i) < nums.get(i)){
                res += (nums.get(i) - arr.get(i));
            }else {
                break;
            }
        }
        System.out.println(res);
    }
}
