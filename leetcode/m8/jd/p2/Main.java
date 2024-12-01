package y24.m8.jd.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(reader.readLine());
        int[] nums = new int[len];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
            map.put(nums[i], i);
        }
        int[] cp = Arrays.copyOf(nums, len);
        Arrays.sort(cp);

        int index = 0;
        int res = 0;
        while (index < len){
            if (nums[index] == cp[index]){
                index++;
                continue;
            }
            int pos = map.get(cp[index]);
            int swapPos = pos - 2;
            while (swapPos >= index){
                swap(nums, swapPos, pos, map);
                pos -= 2;
                swapPos -= 2;
            }
            if (index != pos){
                res++;
                swap(nums, index,pos, map);
            }
            index++;
        }
        System.out.println(res);
    }
    static void swap(int[] nums, int i, int j, Map<Integer, Integer> map){
        map.put(nums[i], j);
        map.put(nums[j], i);

        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
