package y24.m3.d26.p3;

import java.util.*;

class Solution {
    boolean check(String str1,String str2){
        if (str1.length() != str2.length())
            return false;
        int diff = 0;
        for (int i = 0;i < str1.length();++i){
            if (str1.charAt(i) != str2.charAt(i))
                diff++;
        }
        return diff == 1;
    }
    int[] head,nxt,to;
    int cnt = 0;
    void add(int f,int t){
        to[cnt] = t;
        nxt[cnt] = head[f];
        head[f] = cnt++;
    }
    Map<String,Integer> map;
    int index = 0;
    int getIndex(String str){
        if (map.containsKey(str))
            return map.get(str);
        map.put(str,index++);
        return map.get(str);
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean in = false;
        for (String str:wordList){
            if (str.equals(endWord))
                in = true;
        }
        if (!in)
            return 0;
        int n = wordList.size() +2;
        map = new HashMap<>((int) (n*1.4+1));
        for (String str:wordList){
            if (!str.equals(endWord)){
                for (int i = 0;i <str.length();++i){
                    getIndex((i==0?"":str.substring(0,i))+"*"+(i ==str.length()-1?"":str.substring(i + 1)));
                }
            }else {
                getIndex(endWord);
            }
        }
        int m = 2*map.size()*(map.size() - 1);
        head = new int[map.size() + 2];
        Arrays.fill(head, -1);
        nxt = new int[m];
        to = new int[m];
        for (String from:map.keySet()){
            int f = getIndex(from);
            for (String to:map.keySet()){
                if (check(from,to)){
                    // 加点
                    int t = getIndex(to);
                    add(f,t);
                }
            }
        }
        int begin = getIndex(beginWord);
        for (String to:map.keySet()){
            int t = getIndex(to);
            if (check(beginWord,to)){
                add(begin,t);
            }
        }
        // dij

        int end = getIndex(endWord);
        boolean[] visit = new boolean[map.size() + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(begin);
        visit[begin] = true;
        int step = 1;
        while (!queue.isEmpty()){
            int sz = queue.size();
            for (int i = 0; i < sz;++i){
                int s = queue.pollFirst();
                for (int e = head[s]; e != -1;e = nxt[e]){
                    int t = to[e];
                    if (!visit[t]){
                        if (t == end)
                            return step+1;
                        visit[s] = true;
                        queue.addLast(t);
                    }
                }
            }
            step++;
        }
        return 0;
    }
}
class Main{
    public static void main(String[] args) {
//        List<String> list = List.of("hot","dot","dog","lot","log","cog");
        Solution solution = new Solution();
//        int i = solution.ladderLength("hit", "cog", list);
        System.out.println();
    }
}