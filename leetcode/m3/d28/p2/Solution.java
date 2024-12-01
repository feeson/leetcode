package y24.m3.d28.p2;

import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public int oddEvenJumps(int[] arr) {
        int len = arr.length;
        TreeMap<Integer,TreeSet<Integer>> map = new TreeMap();
        for (int i = 0;i < len;++i){
            if (map.containsKey(arr[i])){
                map.get(arr[i]).add(i);
            }else {
                TreeSet set = new TreeSet();
                set.add(i);
                map.put(arr[i],set);
            }
        }
        oddVisit = new boolean[len];
        evenVisit = new boolean[len];
        cnt++;
        dfs(arr,len-1,map,true);
        dfs(arr,len-1,map,false);
        return cnt;
    }
    static boolean[] oddVisit;
    static boolean[] evenVisit;
    int cnt = 0;
    // 从奇数来 -> 当前跟之后的相比离目标点最近且大于目标点，如果目标点比当前值>=则停止寻找
    void dfs(int[] arr, int go,TreeMap<Integer,TreeSet<Integer>> map,boolean odd){
        //奇数来的
        if (odd){
            AtomicInteger indexBiger = new AtomicInteger(-1);
            map.headMap(arr[go],true).descendingMap().forEach((i,set)->{
                Integer lower = set.lower(go);
                if (lower == null) {
                    Map.Entry<Integer, TreeSet<Integer>> entry = map.lowerEntry(arr[go]);
                    while (entry != null && lower == null){
                        lower = entry.getValue().lower(go);
                        if (lower == null){
                            entry = map.lowerEntry(entry.getKey());
                        }
                    }
                }
                if (lower == null)
                    return;
                if (lower > indexBiger.get()){
                    indexBiger.set(lower);
                    if (!oddVisit[lower]){
                        oddVisit[lower] = true;
                        cnt++;
                        dfs(arr,lower,map,!odd);
                    }
                }
            });
        }else {
            AtomicInteger indexBiger = new AtomicInteger(-1);
            map.tailMap(arr[go],true).forEach((i,set)->{
                Integer lower = set.lower(go);
                if (lower == null) {
                    Map.Entry<Integer, TreeSet<Integer>> entry = map.higherEntry(arr[go]);
                    while (entry != null && lower == null){
                        lower = entry.getValue().lower(go);
                        if (lower == null){
                            entry = map.higherEntry(entry.getKey());
                        }
                    }
                }
                if (lower == null)
                    return;
                if (lower > indexBiger.get()){
                    indexBiger.set(lower);
                    if (!evenVisit[lower]){
                        evenVisit[lower] = true;
                        dfs(arr,lower,map,!odd);
                    }
                }
            });
        }
    }
}
class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr =new int[]{5,1,3,4,2};
        solution.oddEvenJumps(arr);
    }
}