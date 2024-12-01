package y24.m8.d19.p1;

import java.util.*;

class Solution {
    public int checkRecord(int n) {
        int n4 = dfsn(new LinkedList<>(), 0, 4);
        if (n <= 7){
            return dfsn(new LinkedList<>(), 0, n);
        }
        int mod = n%3;
        int res = 1;
        return res;
    }
    char[] chars = new char[]{'A','L','P'};
    int dfsn(Deque<Character> list, int n, int target){
        if (list.size() > 1){
            int abcount = 0;
            for (Character c : list) {
                if ('A'==c)
                    abcount++;
                if (abcount > 1)
                    return 0;
            }
        }
        if (list.size() >= 3){
            int ltcount = 0;
            Iterator<Character> itr = list.iterator();
            while (itr.hasNext()){
                Character next = itr.next();
                if (next == 'L'){
                    ltcount = 1;
                    while (itr.hasNext()){
                        Character nx = itr.next();
                        if (nx == 'L')
                            ltcount++;
                        else
                            break;
                        if (ltcount >= 3)
                            return 0;
                    }
                }
            }
        }
        if (n >= target)
            return 1;
        int res = 0;
        for (int i = 0;i < 3; ++i){
            list.addLast(chars[i]);
            res += dfsn(list, n + 1, target);
            list.pollLast();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.checkRecord(7);
        System.out.println(i);
    }
}