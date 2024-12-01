package y24.m5.d5.p8;

import java.util.Arrays;

class Solution {

    public int minExtraChar(String s, String[] dictionary) {
        int dLen = dictionary.length;
        int sLen = s.length();
        int[] minCost = new int[sLen + 1];
        Arrays.fill(minCost, 100);
        int min = 0;
        for (int i = 0; i < sLen; ++i){
            min = Math.min(min, minCost[i]);
            minCost[i] = Math.min(min, minCost[i]);
            nxt:
            for (int j = 0; j < dLen; ++j){
                int index = i + dictionary[j].length();
                if (index > sLen) {
                    continue;
                }
                for (int k = 0; k < dictionary[j].length(); ++k){
                    if (s.charAt(i + k) != dictionary[j].charAt(k)) {
                        continue nxt;
                    }
                }
                minCost[index] = Math.min(minCost[index], minCost[i]);
            }
            min++;
        }
        min = Math.min(min, minCost[sLen]);
        return min;
    }
}

class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = new String[]{"ox","lb","diz","gu","v","ksv","o","nuq","r","txhe","e","wmo","cehy","tskz","ds","kzbu"};
        solution.minExtraChar("dwmodizxvvbosxxw", arr);
    }
}