package y24.m3.d26.p5;

import java.util.ArrayList;
import java.util.List;

class Allocator {

    int[] mem;
    List<Integer>[] mid = new List[1007];
    int len;
    public Allocator(int n) {
        len = n;
        mem = new int[n];
    }

    public int allocate(int size, int mID) {
        if (mid[mID] == null)
            mid[mID] = new ArrayList<>();
        int index = 0;
        while (index < len){
            if (mem[index] ==0){
                int check = index;
                while (check < len){
                    if (check - index + 1 == size){
                        break;
                    }
                    if (mem[check] == 0)
                        check++;
                    else
                        break;
                }
                if (check >= len)
                    return -1;
                if (check - index + 1 == size){
                    mem[index] = size;
                    mid[mID].add(index);
                    return index;
                }else {
                    index = check;
                }
            }else {
                index+=mem[index];
            }
        }
        return -1;
    }

    public int free(int mID) {
        List<Integer> list = mid[mID];
        if (list == null)
            return 0;
        int sz = 0;
        for (int idx:list){
            sz += mem[idx];
            mem[idx] = 0;
        }
        list.clear();
        return sz;
    }
}