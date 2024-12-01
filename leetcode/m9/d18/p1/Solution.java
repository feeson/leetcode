package y24.m9.d18.p1;

import java.util.Arrays;

class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        int latest = 0;
        for(int val: buses){
            latest = Math.max(latest, val);
        }
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int index = 0;
        int takeUp = 0;
        outer:
        for(int busTime: buses){
            while(index < passengers.length){
                int cur = passengers[index];
                if(cur > busTime){
                    takeUp = 0;
                    continue outer;
                }else{
                    index++;
                    takeUp++;
                    if(takeUp == capacity){
                        takeUp = 0;
                        continue outer;
                    }
                }
            }
            if(index == passengers.length){
                return latest;
            }
        }
        if(index <= passengers.length){
            if (index >= 2){
                if (passengers[index - 2] == passengers[index - 1] - 1)
                    return passengers[index - 2] - 1;
            }
            if (index == 0){
                return latest;
            }
            return passengers[index - 1] - 1;
        }
        return latest;
    }

    static void m1(){
        int[] buses = new int[]{20,30,10};
        int[] passengers = new int[]{19,13,26,4,25,11,21};
        int cap = 2;
        Solution solution = new Solution();
        solution.latestTimeCatchTheBus(buses, passengers, cap);
    }

    static void m2(){
        int[] buses = new int[]{20,10};
        int[] passengers = new int[]{2,17,18,19};
        int cap = 2;
        Solution solution = new Solution();
        solution.latestTimeCatchTheBus(buses, passengers, cap);
    }
    public static void main(String[] args) {
        m2();
    }
}