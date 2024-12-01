package y23.m11.d13.p2;

import util.Pair;

import java.io.*;
import java.util.*;

public class Main {
    public Main() throws FileNotFoundException {
    }

    public static class Pair<T1,T2> {
        public T1 key;
        public T2 value;
        Pair(T1 t1,T2 t2){
            key=t1;
            value=t2;
        }
        public T1 getKey(){
            return key;
        }
        public T2 getValue(){
            return value;
        }
        public void setKey(T1 key1){
            key=key1;
        }
        public void setValue(T2 value1){
            value=value1;
        }
    }

    static void toRes(Integer[] nums,int n){
        for (int i = 0;i<n;++i){
            System.out.print(nums[i]+" ");
        }
        return;
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        Deque<Pair<Integer,Integer>> deque=new ArrayDeque<>();
        for (int i=0;i<m;++i){
            s = scanner.nextLine();
            s1 = s.split(" ");
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);
            if (deque.isEmpty()){
                if (x == 0)
                    deque.addLast(new Pair<>(0,y));
                continue;
            }
            Pair<Integer, Integer> lastPair = deque.pollLast();
            if (lastPair.getKey() == x){
                if (x == 0){
                    deque.addLast(new Pair<>(0,Math.max(lastPair.getValue(),y)));
                }else {
                    deque.addLast(new Pair<>(1,Math.min(lastPair.getValue(),y)));
                }
                continue;
            }
            if (x == 0){
                while (deque.size() > 1 && deque.peekLast().getValue() <= y){
                    deque.pollLast();
                    lastPair = deque.pollLast();
                }
                deque.addLast(lastPair);
                deque.addLast(new Pair<>(0,y));
            }else {
                while (deque.size() > 1 && deque.peekLast().getValue() >= y){
                    deque.pollLast();
                    lastPair = deque.pollLast();
                }
                deque.addLast(lastPair);
                deque.addLast(new Pair<>(1,y));
            }
        }
        int[] nums = new int[n+1];
        for (int i=1;i<=n;++i){
            nums[i] = i;
        }
        int l = 1,r = n,last = n;
        int size = deque.size();
        while (!deque.isEmpty()){
            Pair<Integer, Integer> pair = deque.pollFirst();
            if (pair.getKey() ==0){
                while (l < r && r > pair.getValue()){
                    nums[r--] = nums[last--];
                }
            }else {
                while (l < r && l< pair.getValue()){
                    nums[l++] = nums[last--];
                }
            }
        }
        while (l < r){
            nums[l++] = nums[last--];
        }
        for (int i =1;i<n ; ++i){
            System.out.print(nums[i] + " ");
        }
        System.out.println(nums[n]);
        File file = new File("C:\\Users\\25404\\Downloads\\output1 (2).txt");
        FileInputStream fileInputStream=new FileInputStream(file);
        InputStreamReader isr=new InputStreamReader(fileInputStream);
        BufferedReader bf = new BufferedReader(isr);
        while ((s = bf.readLine()) != null){
            String[] s2 = s.split(" ");
            for (int i = 0;i<s2.length;++i){
                if (Integer.parseInt(s2[i]) != nums[i+1])
                    System.out.println((i+1)+" "+nums[i+1]);
            }
        }
    }


}
