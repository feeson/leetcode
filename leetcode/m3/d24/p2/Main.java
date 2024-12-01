package y24.m3.d24.p2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[m];
        dfs(1,arr,0,m,n);
    }
    static void print(int[] arr){
        for (int val:arr){
            System.out.print(val+" ");
        }
        System.out.println();
    }
    static void dfs(int start,int[]arr,int index,int m,int n){
        if (index == m){
            print(arr);
            return;
        }
        for (int i = start;i <=n;++i){
            arr[index] = i;
            dfs(i + 1,arr,index + 1,m,n);
        }
    }
}
