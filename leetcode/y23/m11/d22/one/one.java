package y23.m11.d22.one;

import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalraw = scanner.nextInt();
        int[]numbers = new int[totalraw];
        for (int i = 0;i<totalraw;++i){
            numbers[i] = scanner.nextInt();
        }
        for (int val:numbers){
            System.out.println(getClick(val));
        }
    }
    static int getClick(int x){
        int cnt = 0;
        loop:
        for (int i=1;i<=9;++i){
            int num = i;
            int tc = 1;
            while (num < 10000){
                cnt+=tc;
                if (num == x) {
                    break loop;
                }
                tc++;
                num=num*10+i;
            }
        }
        return cnt;
    }
}
