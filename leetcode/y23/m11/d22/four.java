package y23.m11.d22;

import java.util.*;

public class four {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[]num = new int[3];
        int t = 0;
        for (String st:s.split(" "))
            num[t++] = Integer.parseInt(st);
        int n=num[0];
        int m=num[1];
        int k=num[2];

        int[][] map = new int[n][n];
        for (int i=0;i<n;++i){
            Arrays.fill(map[i],-1);
            map[i][i] = 0;
        }
        int[][]edge= new int[m][3];
        for (int i=0;i<m;++i){
            t=0;
            s = scanner.nextLine();
            for (String st:s.split(" "))
                num[t++] = Integer.parseInt(st);
            edge[i][0] = num[0];
            edge[i][1] = num[1];
            edge[i][2] =num[2];
        }
        for (int i=0;i<m;++i){
            int n1 = edge[i][0];
            int n2 = edge[i][1];
            
        }
    }
}